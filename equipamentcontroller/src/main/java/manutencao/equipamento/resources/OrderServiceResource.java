package manutencao.equipamento.resources;

import manutencao.equipamento.entities.OrderService;
import manutencao.equipamento.entities.dto.OrderServiceDTO;
import manutencao.equipamento.services.OrderServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderService")
public class OrderServiceResource {

    @Autowired
    private OrderServiceService service;

    @Transactional(readOnly = true)
    @GetMapping
    public List<OrderService> findAll() {
        return service.findAll();
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderService findById(@PathVariable("id") Long id) {
        Optional<OrderService> orderService = service.findById(id);
        if (!orderService.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    new Exception("Order Service not found").getMessage());
        return orderService.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderService save(@RequestBody OrderServiceDTO dto) {
        OrderService orderServiceSave = service.save(dtoToEntity(dto));
        if (orderServiceSave == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return orderServiceSave;
    }

    @Transactional(readOnly = true)
    @GetMapping("/responsible/{id}")
    public List<OrderService> findPendingByResponsibleId(@PathVariable("id") Long id) {
        return service.findPendingByResponsibleId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderService serviceDone(@PathVariable("id") Long id, @RequestBody OrderServiceDTO dto) {
        Optional<OrderService> orderService = service.findById(id);
        if (!orderService.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    new Exception("Order Service not found").getMessage());
        }
        orderService.get().setClosedDate(dto.getClosedDate());
        orderService.get().setServiceDone(dto.getServiceDone());

        return service.save(orderService.get());
    }

    private OrderService dtoToEntity(OrderServiceDTO obj) {
        OrderService os = new OrderService(obj.getId(), obj.getClient(), obj.getEmissionDate(), obj.getClosedDate(), obj.getProblemDescription(), obj.getEquipament(), obj.getResponible(), obj.getServiceDone());
        return os;
    }
}