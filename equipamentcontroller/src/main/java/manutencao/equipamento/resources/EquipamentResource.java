package manutencao.equipamento.resources;

import manutencao.equipamento.entities.Client;
import manutencao.equipamento.entities.Equipament;
import manutencao.equipamento.entities.dto.ClientDTO;
import manutencao.equipamento.entities.dto.EquipamentDTO;
import manutencao.equipamento.services.EquipamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping("/equipament")
public class EquipamentResource {

    @Autowired
    private EquipamentService service;

    @Transactional(readOnly = true)
    @GetMapping
    public List<Equipament> findAll(){
        return service.findAll();
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Equipament findById(@PathVariable("id") Long id) {
        Optional<Equipament> equipament = service.findById(id);

        if (!equipament.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    new Exception("Equipament not found").getMessage());
        }
        return equipament.get();
    }

    private Equipament dtoToEntity(EquipamentDTO obj) {
        Equipament eq = new Equipament(obj.getId(), obj.getBrand(), obj.getType());
        return eq;
    }
}
