package com.notification.notifications.services;

import com.notification.notifications.models.Notification;
import com.notification.notifications.models.NotificationManager;
import com.notification.notifications.repositories.NotificationManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationManagerServiceImpl implements NotificationManagerService {

    @Autowired
    private NotificationManagerRepo notificationManagerRepo;

    public void markNotificationAsRead(String id, String indicator) {
        NotificationManager existingNotificationManager = notificationManagerRepo.findById(id).orElse(null);
        Boolean indicatorValue;
        if(indicator.equalsIgnoreCase("false")) {
            indicatorValue = false;
        } else {
            indicatorValue = true;
        }
        existingNotificationManager.setReadMessage(indicatorValue);
        notificationManagerRepo.save(existingNotificationManager);
    }



}
