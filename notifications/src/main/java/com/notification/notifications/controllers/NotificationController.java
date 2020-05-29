package com.notification.notifications.controllers;

import com.notification.notifications.PerRequestIdStorage;
import com.notification.notifications.models.Notification;
import com.notification.notifications.services.NotificationService;
import com.notification.notifications.transports.NotificationListTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.List;

@RestController
@RequestMapping("notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public NotificationListTransport getMyNotifications() {
        return notificationService.listAllNotifications(PerRequestIdStorage.getUserId());
    }

    @PutMapping("{notificationId}")
    public void alterNotificationReadStatus(@PathVariable String notificationId, @RequestParam("isOpened") boolean isOpened) {
        notificationService.updateNotificationReadStatus(notificationId, isOpened);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    public void deleteNotification(@PathVariable String id) {
        notificationService.deleteNotificationById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void deleteMyNotifications() {
        notificationService.deleteMyNotifications(PerRequestIdStorage.getUserId());
    }

}
