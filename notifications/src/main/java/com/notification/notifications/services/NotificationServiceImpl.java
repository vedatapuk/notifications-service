package com.notification.notifications.services;

import com.notification.notifications.integration.models.SerializableNotification;
import com.notification.notifications.mappers.NotificationMapper;
import com.notification.notifications.models.Notification;
import com.notification.notifications.repositories.NotificationRepo;
import com.notification.notifications.transports.NotificationListTransport;
import com.notification.notifications.transports.NotificationTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Override
    public NotificationListTransport listAllNotifications(String userId) {
        List<Notification> notifications = notificationRepo.findByRecipientId(userId);
        return new NotificationListTransport(notifications.stream().map(NotificationMapper::notificationToNotificationTransport).collect(Collectors.toList()));
    }

    @Override
    public void saveNotification(NotificationTransport notificationTransport) {
        Notification notification = new Notification(UUID.randomUUID().toString(), notificationTransport.getCreatedDate(),
                notificationTransport.getNotificationLink(), notificationTransport.getContent(), notificationTransport.isRead(),
                notificationTransport.getRecipientId());
        notificationRepo.save(notification);
    }

    @Override
    public void deleteNotificationById(String id) {
        notificationRepo.deleteById(id);
    }

    @Override
    public void updateNotificationReadStatus(String notificationId, boolean isRead) {
        Notification notification = notificationRepo.findById(notificationId).orElseThrow(() -> new NoSuchElementException("Notification not found!"));
        notification.setRead(isRead);
        notificationRepo.save(notification);
    }

    @Override
    public void deleteMyNotifications(String userId) {
        notificationRepo.deleteByRecipientId(userId);
    }

    @Override
    public void buildNotifications(SerializableNotification serializableNotification) {
        for(String recipientId : serializableNotification.getRecipients()) {
            Notification notification = new Notification(UUID.randomUUID().toString(), new Timestamp(System.currentTimeMillis()), "",
                    serializableNotification.getContent(), false, recipientId);
            notificationRepo.save(notification);
        }
    }

}
