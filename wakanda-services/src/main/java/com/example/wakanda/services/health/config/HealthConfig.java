package com.example.wakanda.services.health.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class HealthConfig {

    private static final int THREAD_POOL_SIZE = 10;

    @Bean
    public ExecutorService taskExecutor() {
        return Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    @Bean
    public Queue healthQueue() {
        return new Queue("health-monitor-queue", true);
    }

    @Bean
    public DirectExchange healthExchange() {
        return new DirectExchange("health-monitor-exchange");
    }

    @Bean
    public Binding healthBinding(Queue healthQueue, DirectExchange healthExchange) {
        return BindingBuilder.bind(healthQueue).to(healthExchange).with("healthKey");
    }
}
