package com.example.reto3doctor.controller;

import com.example.reto3doctor.model.MessageModel;
import com.example.reto3doctor.model.SpecialtyModel;
import com.example.reto3doctor.service.MessageService;
import com.example.reto3doctor.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    public Optional<MessageModel> getMessage(@PathVariable("id") Integer id){
        return messageService.getMessage(id);
    }
    @PostMapping("/save")
    public MessageModel saveMessage(@RequestBody MessageModel messageModel){
        return messageService.saveMessage(messageModel);
    }

    @PutMapping("/update")
    public MessageModel updateMessage(@RequestBody MessageModel messageModel){
        return messageService.updateMessage(messageModel);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteMessage(@PathVariable Integer id){
        return  messageService.deleteMessage(id);
    }

}
