package com.notification.notifications.services;

import com.notification.notifications.transports.NotificationListTransport;
import com.notification.notifications.transports.NotificationTransport;

public interface NotificationService {

    NotificationListTransport listAllNotifications(String userId);

    void saveNotification(NotificationTransport notificationTransport);

    void updateNotificationReadStatus(String notificationId, boolean isRead);

    void deleteNotificationById(String id);

    void deleteMyNotifications(String userId);

}
