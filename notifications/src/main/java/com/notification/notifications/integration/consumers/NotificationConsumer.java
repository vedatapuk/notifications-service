package com.notification.notifications.integration.consumers;

import com.notification.notifications.integration.models.SerializableNotification;
import com.notification.notifications.services.NotificationServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    private NotificationServiceImpl notificationService;

    public NotificationConsumer(NotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = {"${queue.notification}"})
    public void handleNewNotification(SerializableNotification serializableNotification) {
        notificationService.buildNotifications(serializableNotification);
    }

}
