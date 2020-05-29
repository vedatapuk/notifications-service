package com.notification.notifications.mappers;

import com.notification.notifications.models.Notification;
import com.notification.notifications.transports.NotificationTransport;

public class NotificationMapper {

    public static NotificationTransport notificationToNotificationTransport(Notification notification) {
        return new NotificationTransport(notification.getId(), notification.getCreatedDate(),
                notification.getNotificationLink(), notification.getContent(), notification.isOpened(),
                notification.getRecipientId());
    }

}
