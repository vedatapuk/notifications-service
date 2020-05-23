package com.notification.notifications.services;

import com.notification.notifications.models.Notification;
import com.notification.notifications.repositories.MessageRepo;
import com.notification.notifications.repositories.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    public List<Notification> listAllNotifications() {
        return notificationRepo.findAll();
    }

    public Notification saveNotification(Notification notification) {
        return notificationRepo.save(notification);
    }

    public void deleteNotificationById(String id) {
        notificationRepo.deleteById(id);
    }

    public void deleteAllNotifications() {
        notificationRepo.deleteAll();
    }



}
