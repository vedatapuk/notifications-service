package com.notification.notifications.controllers;

import com.notification.notifications.models.Message;
import com.notification.notifications.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PutMapping("/{id}")
    public Message editMessage(@PathVariable String id, @RequestBody Message message) {
        return messageService.editMessageContent(id, message);
    }
}
