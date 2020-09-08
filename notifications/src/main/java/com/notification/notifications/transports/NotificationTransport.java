package com.notification.notifications.transports;

import com.notification.notifications.annotations.ApiEntity;

import java.sql.Timestamp;

@ApiEntity
public class NotificationTransport {

    private String id;
    private Timestamp createdDate;
    private String notificationLink;
    private String content;
    private boolean read;
    private String recipientId;

    public NotificationTransport(Timestamp createdDate, String notificationLink, String content, boolean read, String recipientId) {
        this.createdDate = createdDate;
        this.notificationLink = notificationLink;
        this.content = content;
        this.read = read;
        this.recipientId = recipientId;
    }

    public NotificationTransport(String id, Timestamp createdDate, String notificationLink, String content, boolean read, String recipientId) {
        this.id = id;
        this.createdDate = createdDate;
        this.notificationLink = notificationLink;
        this.content = content;
        this.read = read;
        this.recipientId = recipientId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getNotificationLink() {
        return notificationLink;
    }

    public void setNotificationLink(String notificationLink) {
        this.notificationLink = notificationLink;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

}
