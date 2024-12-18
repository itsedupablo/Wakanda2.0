package com.example.wakanda.integration;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

    @RabbitListener(queues = "wakanda.queue")
    public void consumeMessage(String message) {
        System.out.println("Message received: " + message);
    }
}
