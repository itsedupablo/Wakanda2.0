package com.example.wakanda.services.health.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class HealthMessageListener {

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    @RabbitListener(queues = "health-monitor-queue")
    public void processHealthMonitorUpdate(String message) {
        executorService.submit(() -> {
            System.out.println("Processing message in thread: " + Thread.currentThread().getName());
            System.out.println("Message: " + message);
        });
    }
}
