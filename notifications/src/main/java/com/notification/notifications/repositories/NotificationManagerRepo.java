package com.notification.notifications.repositories;

import com.notification.notifications.models.NotificationManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationManagerRepo extends JpaRepository<NotificationManager, String> {
}
