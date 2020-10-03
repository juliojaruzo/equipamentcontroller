package manutencao.equipamento.services;

import manutencao.equipamento.entities.Client;
import manutencao.equipamento.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll(){
        return repository.findAll();
    }

    public Optional<Client> findById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Client save(Client client) {
        return repository.save(client);
    }

    public Client update(Client client) {
        return repository.save(client);
    }
}
