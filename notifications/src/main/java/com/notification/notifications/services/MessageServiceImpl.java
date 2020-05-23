package com.notification.notifications.services;

import com.notification.notifications.models.Message;
import com.notification.notifications.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepo messageRepository;

    public Message editMessageContent(String id, Message message) {
        Message existingMessage = messageRepository.findById(id).orElse(null);
        existingMessage.setMessageContent(message.getMessageContent());
        return messageRepository.save(existingMessage);
    }
}
