package com.notification.notifications.transports;

import java.util.List;

public class NotificationListTransport {

    private List<NotificationTransport> notificationTransports;

    public NotificationListTransport(List<NotificationTransport> notificationTransports) {
        this.notificationTransports = notificationTransports;
    }

    public List<NotificationTransport> getNotificationTransports() {
        return notificationTransports;
    }

    public void setNotificationTransports(List<NotificationTransport> notificationTransports) {
        this.notificationTransports = notificationTransports;
    }

}
