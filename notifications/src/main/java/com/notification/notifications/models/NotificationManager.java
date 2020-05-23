package com.notification.notifications.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notification_manager")
public class NotificationManager {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "not_man_id", columnDefinition = "VARCHAR(255)")
    private String notManId;

    @Column(name = "recipient_id")
    private String recipientId;

    @Value("false")
    @Column(name = "read_message")
    private Boolean readMessage;

    public String getNotManId() {
        return notManId;
    }

    public void setNotManId(String notManId) {
        this.notManId = notManId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public Boolean getReadMessage() {
        return readMessage;
    }

    public void setReadMessage(Boolean readMessage) {
        this.readMessage = readMessage;
    }
}
