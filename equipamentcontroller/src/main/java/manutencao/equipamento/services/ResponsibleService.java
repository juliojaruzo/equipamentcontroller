package manutencao.equipamento.services;


import manutencao.equipamento.entities.Responsible;
import manutencao.equipamento.repositories.ResponsibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsibleService {

    @Autowired
    private ResponsibleRepository repository;

    public List<Responsible> findAll(){
        return repository.findAll();
    }

    public Optional<Responsible> findById(Long id){
        return repository.findById(id);
    }

    public Responsible save(Responsible responsible){
        return repository.save(responsible);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
