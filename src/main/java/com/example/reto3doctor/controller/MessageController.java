package com.example.reto3doctor.controller;

import com.example.reto3doctor.model.MessageModel;
import com.example.reto3doctor.model.SpecialtyModel;
import com.example.reto3doctor.service.MessageService;
import com.example.reto3doctor.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins="*")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<MessageModel> getAllMessages(){
        return messageService.getAllMessages();
    }

    @GetMapping("/{idMessage}")
    public Optional<MessageModel> getMessage(@PathVariable("id") Integer id){
        return messageService.getMessage(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageModel saveMessage(@RequestBody MessageModel messageModel){
        return messageService.saveMessage(messageModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageModel updateMessage(@RequestBody MessageModel messageModel){
        return messageService.updateMessage(messageModel);
    }

    @DeleteMapping("/{idMessage}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMessage(@PathVariable Integer idMessage){
        return  messageService.deleteMessage(idMessage);
    }

}
