package com.notification.notifications.mappers;

import com.notification.notifications.models.Notification;
import com.notification.notifications.transports.NotificationTransport;

public class NotificationMapper {

    public static NotificationTransport notificationToNotificationTransport(Notification notification) {
        return new NotificationTransport(notification.getNotificationId(), notification.getCreatedDate(),
                notification.getNotificationLink(), notification.getContent(), notification.isRead(),
                notification.getRecipientId());
    }

}
