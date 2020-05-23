package com.notification.notifications.controllers;

import com.notification.notifications.models.Message;
import com.notification.notifications.services.NotificationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class NotificationManagerController {

    @Autowired
    private NotificationManagerService notificationManagerService;

    @PutMapping("/{id}/indicator") //http://localhost:8080/manager/gfdsa/indicator?indicator=TRUE
    public void markAsRead(@PathVariable String id, @RequestParam("indicator") String indicator) {
        notificationManagerService.markNotificationAsRead(id, indicator);
    }
}
