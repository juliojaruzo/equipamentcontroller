package manutencao.equipamento.resources;


import com.fasterxml.classmate.AnnotationOverrides;
import manutencao.equipamento.entities.Client;
import manutencao.equipamento.entities.dto.ClientDTO;
import manutencao.equipamento.services.ClientService;
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
@RequestMapping("/client")
public class ClientResource {

    @Autowired
    ClientService service;

    @Transactional(readOnly = true)
    @GetMapping
    public List<Client> findAll() {
        return service.findAll();
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") Long id) {
        Optional<Client> cliente = service.findById(id);

        if (!cliente.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, new Exception("Client not found").getMessage());
        }
        return ResponseEntity.ok(cliente.get());
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody ClientDTO clientDTO) {
        Client client = service.save(dtoToEntity(clientDTO));
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.badRequest().build();
    }

    private Client dtoToEntity(ClientDTO obj) {
        Client cli = new Client(obj.getId(), obj.getName(), obj.getAdress(), obj.getEmail(), obj.getPhone());
        return cli;
    }
}