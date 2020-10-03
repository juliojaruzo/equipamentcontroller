package manutencao.equipamento.resources;


import manutencao.equipamento.entities.Responsible;
import manutencao.equipamento.entities.dto.ResponsibleDTO;
import manutencao.equipamento.services.ResponsibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping("/responsible")
public class ResponsibleResource {

    @Autowired
    private ResponsibleService service;

    @Transactional
    @GetMapping
    public List<Responsible> findAll(){
        return service.findAll();
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Responsible>> findById(@PathVariable("id") Long id) {
        Optional<Responsible> responsible = service.findById(id);
        if (!responsible.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    new Exception("Responsible not found").getMessage());
        }
        return ResponseEntity.ok(responsible);
    }

    @PostMapping
    public ResponseEntity<Responsible> save(@RequestBody ResponsibleDTO dto) {
        Responsible responsible = service.save(dtoToEntity(dto));
        return responsible != null ? ResponseEntity.ok(responsible) : ResponseEntity.badRequest().build();
    }

    private Responsible dtoToEntity(ResponsibleDTO obj) {
       Responsible res = new Responsible(obj.getId(), obj.getName());
       return res;
    }
}
