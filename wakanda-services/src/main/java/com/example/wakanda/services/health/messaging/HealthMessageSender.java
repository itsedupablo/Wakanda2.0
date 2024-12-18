package com.example.wakanda.services.health.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class HealthMessageSender {

    private final RabbitTemplate rabbitTemplate;

    public HealthMessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendHealthMonitorUpdate(String message) {
        rabbitTemplate.convertAndSend("health-monitor-queue", message);
    }
}
