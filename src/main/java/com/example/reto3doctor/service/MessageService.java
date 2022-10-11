package com.example.reto3doctor.service;

import com.example.reto3doctor.Repository.MessageRepository;
import com.example.reto3doctor.Repository.SpecialtyRepository;
import com.example.reto3doctor.model.MessageModel;
import com.example.reto3doctor.model.SpecialtyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired

    private MessageRepository messageRepository;


    public List<MessageModel> getAllMessages(){
        return messageRepository.getAllMessages();
    }

    public Optional<MessageModel> getMessage(Integer id){
        return messageRepository.getMessage(id);
    }

    public MessageModel saveMessage(MessageModel messageModel){
        return messageRepository.saveMessage(messageModel);
    }

    public MessageModel updateMessage(MessageModel messageModel){
        return messageRepository.updateMessage(messageModel);
    }
    public boolean deleteMessage(Integer id) {
        messageRepository.deleteMessage(id);
        return true;}

}
