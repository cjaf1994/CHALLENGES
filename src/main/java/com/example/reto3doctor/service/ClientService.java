package com.example.reto3doctor.service;

import ch.qos.logback.core.net.server.Client;
import com.example.reto3doctor.Repository.ClientRepository;
import com.example.reto3doctor.model.AdminModel;
import com.example.reto3doctor.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired

    private ClientRepository clientRepository;

    public List<ClientModel> getAllClients(){
        return clientRepository.getAllClients();
    }
    public Optional<ClientModel> getClient(Integer id){
        return clientRepository.getClient(id);
    }


    public ClientModel saveClient(ClientModel clientModel ){
        if(clientModel.getIdClient()==null){
            return clientRepository.saveClient(clientModel);
        }else{
            Optional<ClientModel> optionalClientModel= clientRepository.getClient(clientModel.getIdClient());
            if(optionalClientModel.isEmpty()){
                return clientRepository.saveClient(clientModel);
            }else {
                return clientModel;
            }
        }
    }

    public ClientModel updateClient(ClientModel clientModel) {
        if (clientModel.getIdClient() != null) {
            Optional<ClientModel> optionalClientModel =clientRepository.getClient((clientModel.getIdClient()));
            if (!optionalClientModel.isEmpty()) {
                if (clientModel.getEmail() != null){
                    optionalClientModel.get().setEmail(clientModel.getEmail());
                }
                if (clientModel.getPassword() != null) {
                    optionalClientModel.get().setPassword(clientModel.getPassword());
                }
                if (clientModel.getName() != null) {
                    optionalClientModel.get().setName(clientModel.getName());
                }
                if (clientModel.getAge() != null) {
                    optionalClientModel.get().setAge(clientModel.getAge());
                }
                clientRepository.saveClient(optionalClientModel.get());
                return optionalClientModel.get();
            } else {
                return clientModel;
            }
        }return clientModel;
    }

    public boolean deleteClient(Integer id) {
        Boolean aBoolean=getClient(id).map(clientModel1-> {
            clientRepository.deleteClient(clientModel1.getIdClient());
            return true;
        }).orElse(false);
        return aBoolean;
    }


}
