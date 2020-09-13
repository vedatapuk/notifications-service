package com.notification.notifications.integration.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueuesConfiguration {

    @Value("${queue.notification}")
    private String notificationQueue;

    @Bean(name = "notificationQueue")
    public Queue notificationQueue() {
        return new Queue(notificationQueue);
    }

}
