package com.example.reto3doctor.Repository;

import com.example.reto3doctor.Repository.crudrepository.ClientCrudRepository;
import com.example.reto3doctor.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<ClientModel> getAllClients(){
        return (List<ClientModel>) clientCrudRepository.findAll();
    }
    public Optional<ClientModel> getClient(Integer id){
        return clientCrudRepository.findById(id);
    }
    public ClientModel saveClient(ClientModel clientModel){
        return clientCrudRepository.save(clientModel);
    }

    public ClientModel updateClient(ClientModel clientModel){
        return clientCrudRepository.save(clientModel);
    }

    public boolean deleteClient(Integer id) {
        clientCrudRepository.deleteById(id);
        return true;
    }


}
