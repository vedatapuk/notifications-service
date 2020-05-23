package com.notification.notifications.services;

import com.notification.notifications.models.Message;

public interface MessageService {

    Message editMessageContent(String id, Message message);

}
