package manutencao.equipamento.services;


import manutencao.equipamento.entities.OrderService;
import manutencao.equipamento.repositories.OrderServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceService {

    @Autowired
    private OrderServiceRepository repository;

    public List<OrderService> findAll(){
        return repository.findAll();
    }

    public Optional<OrderService> findById(Long id){
        return repository.findById(id);
    }

    public OrderService save(OrderService orderService){
        return repository.save(orderService);
    }

    public List<OrderService> findPendingByResponsibleId(Long responsibleId){
        return repository.findByResponsibleIdAndClosedDateIsNull(responsibleId);
    }
}
