package com.notification.notifications.services;

import com.notification.notifications.integration.models.SerializableNotification;
import com.notification.notifications.mappers.NotificationMapper;
import com.notification.notifications.models.Notification;
import com.notification.notifications.repositories.NotificationRepo;
import com.notification.notifications.transports.NotificationListTransport;
import com.notification.notifications.transports.NotificationTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;
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
        Notification notification = new Notification(notificationTransport.getCreatedDate(),
                notificationTransport.getNotificationLink(), notificationTransport.getContent(), notificationTransport.isRead(),
                notificationTransport.getRecipientId());
        notificationRepo.save(notification);
    }

    @Transactional
    @Override
    public void deleteNotificationById(String id) {
        notificationRepo.deleteById(id);
    }

    @Override
    public void updateNotificationReadStatus(String notificationId, boolean isOpened) {
        Notification notification = notificationRepo.findById(notificationId).orElseThrow(() -> new NoSuchElementException("Notification not found!"));
        notification.setOpened(isOpened);
        notificationRepo.save(notification);
    }

    @Transactional
    @Override
    public void deleteMyNotifications(String userId) {
        notificationRepo.deleteByRecipientId(userId);
    }

    @Override
    public void buildNotifications(SerializableNotification serializableNotification) {
        List<Notification> notifications = new ArrayList<>();
        for(String recipientId : serializableNotification.getRecipients()) {
            Notification notification = new Notification(new Timestamp(System.currentTimeMillis()), "/notifications/list",
                    serializableNotification.getContent(), recipientId);
            notifications.add(notification);
        }
        notificationRepo.saveAll(notifications);
    }

}
