package manutencao.equipamento.services;

import manutencao.equipamento.entities.Equipament;
import manutencao.equipamento.repositories.EquipamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentService {

    @Autowired
    private EquipamentRepository repository;

    public List<Equipament> findAll(){
        return repository.findAll();
    }

    public Optional<Equipament> findById(Long id){
        return repository.findById(id);
    }

    public Equipament update(Equipament equipament){
        return repository.save(equipament);
    }

    public Equipament save(Equipament equipament){
     return repository.save(equipament);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
