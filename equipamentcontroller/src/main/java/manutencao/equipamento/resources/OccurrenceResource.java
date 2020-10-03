package manutencao.equipamento.resources;


import manutencao.equipamento.entities.Equipament;
import manutencao.equipamento.entities.Occurrence;
import manutencao.equipamento.entities.dto.OccurrenceDTO;
import manutencao.equipamento.services.OccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/occurrence")
public class OccurrenceResource {

    @Autowired
    private OccurrenceService service;

    @GetMapping
    public List<Occurrence> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Occurrence findById(@PathVariable("id") Long id) {
        Optional<Occurrence> occurrence = service.findById(id);
        if (!occurrence.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    new Exception("Ocorrencia não encontrada.").getMessage());
        return occurrence.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Occurrence save(@RequestBody OccurrenceDTO dto) {
        Occurrence saveOccurrence = service.save(dtoToEntity(dto));

        if (saveOccurrence == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        return saveOccurrence;
    }

    private Occurrence dtoToEntity(OccurrenceDTO obj){
        Occurrence oq = new Occurrence(obj.getId(), obj.getDescription(), obj.getOrderService());
        return oq;
    }
}
