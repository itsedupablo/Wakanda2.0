package com.example.wakanda.services.traffic.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TrafficMessageSender {

    private final RabbitTemplate rabbitTemplate;
    private final String exchange;
    private final String routingKey;

    public TrafficMessageSender(RabbitTemplate rabbitTemplate,
                                @Value("${traffic.exchange.name}") String exchange,
                                @Value("${traffic.routing.key}") String routingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        System.out.println("Mensaje enviado a " + exchange + " con la ruta " + routingKey + ": " + message);
    }
}