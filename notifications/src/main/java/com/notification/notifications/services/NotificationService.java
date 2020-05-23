package com.notification.notifications.services;

import com.notification.notifications.models.Notification;

import java.util.List;

public interface NotificationService {

    List<Notification> listAllNotifications();

    Notification saveNotification(Notification notification);

    void deleteNotificationById(String id);

    void deleteAllNotifications();

}
