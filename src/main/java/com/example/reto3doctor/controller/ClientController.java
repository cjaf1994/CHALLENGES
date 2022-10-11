package com.example.reto3doctor.controller;

import com.example.reto3doctor.model.ClientModel;
import com.example.reto3doctor.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins="*")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<ClientModel> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Optional<ClientModel> getClient(@PathVariable("id") Integer id){
        return clientService.getClient(id);
    }
    @PostMapping("/save")
    public ClientModel saveClient(@RequestBody ClientModel clientModel){
        return clientService.saveClient(clientModel);
    }

    @PutMapping("/update")
    public ClientModel updateClient(@RequestBody ClientModel clientModel){
        return clientService.updateClient(clientModel);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteClient(@PathVariable Integer id){
        return  clientService.deleteClient(id);
    }

}
