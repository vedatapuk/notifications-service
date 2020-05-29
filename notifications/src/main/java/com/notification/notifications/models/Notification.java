package com.notification.notifications.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "NVARCHAR(36)")
    private String id;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "notification_link")
    private String notificationLink;

    @Column(name = "content")
    private String content;

    @Column(name = "opened", columnDefinition = "boolean default 0")
    private Boolean opened = false;

    @Column(name = "recipient_id")
    private String recipientId;

    public Notification() {

    }

    public Notification(Timestamp createdDate, String notificationLink, String content, String recipientId) {
        this.createdDate = createdDate;
        this.notificationLink = notificationLink;
        this.content = content;
        this.recipientId = recipientId;
    }

    public Notification(Timestamp createdDate, String notificationLink, String content, Boolean opened, String recipientId) {
        this.createdDate = createdDate;
        this.notificationLink = notificationLink;
        this.content = content;
        this.opened = opened;
        this.recipientId = recipientId;
    }

    public Notification(String id, Timestamp createdDate, String notificationLink, String content, boolean opened, String recipientId) {
        this.id = id;
        this.createdDate = createdDate;
        this.notificationLink = notificationLink;
        this.content = content;
        this.opened = opened;
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

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

}
