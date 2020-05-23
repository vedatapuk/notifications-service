package com.notification.notifications.controllers;

import com.notification.notifications.models.Notification;
import com.notification.notifications.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/")
    public List<Notification> findAllNotifications() {
        return notificationService.listAllNotifications();
    }

    //KTO DUHET ME RREGULLU
    @PostMapping("/")
    public Notification sendNotification(@RequestBody Notification notification) {
        return notificationService.saveNotification(notification);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable String id) {
        notificationService.deleteNotificationById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/")
    public void deleteAllNotifications() {
        notificationService.deleteAllNotifications();
    }

}
