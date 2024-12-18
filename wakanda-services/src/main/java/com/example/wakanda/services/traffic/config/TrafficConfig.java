package com.example.wakanda.services.traffic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrafficConfig {
    @Bean
    public Queue trafficQueue() {
        return new Queue("trafficQueue", true);
    }

    @Bean
    public DirectExchange trafficExchange() {
        return new DirectExchange("trafficExchange");
    }

    @Bean
    public Binding trafficBinding(Queue trafficQueue, DirectExchange trafficExchange) {
        return BindingBuilder.bind(trafficQueue).to(trafficExchange).with("trafficKey");
    }
}
 