package com.notification.notifications.repositories;

import com.notification.notifications.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, String> {

    List<Notification> findByRecipientId(String userId);

    void deleteByRecipientId(String userId);

}
