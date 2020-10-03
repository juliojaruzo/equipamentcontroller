package manutencao.equipamento.services;

import manutencao.equipamento.entities.Occurrence;
import manutencao.equipamento.repositories.OccurrenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccurrenceService {

    @Autowired
    private OccurrenceRepository repository;

    public List<Occurrence> findAll(){
        return repository.findAll();
    }

    public Optional<Occurrence> findById(Long id){
        return repository.findById(id);
    }

    public Occurrence save(Occurrence occurrence){
        return repository.save(occurrence);
    }
}
