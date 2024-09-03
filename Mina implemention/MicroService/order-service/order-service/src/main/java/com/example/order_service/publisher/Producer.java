package com.example.order_service.publisher;


import com.example.order_service.model.OrderEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Producer {


    @Value("${rabbitMq.exchange.name}")
    private String exhange;
    @Value("${rabbitMq.stock.routing.key}")
    private String stockRoutingKey;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${rabbitMq.email.routing.key}")
    private String emailRoutingKey;

    public void send(OrderEvent orderEvent) {
        /// send the message to Stock Queue
        rabbitTemplate.convertAndSend(exhange, stockRoutingKey, orderEvent);
        /// send the message to email Queue
        rabbitTemplate.convertAndSend(exhange, emailRoutingKey, orderEvent);

    }
}
