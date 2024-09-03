package com.example.SpringWithRabbitMQ.publisher;

import com.example.SpringWithRabbitMQ.dto.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingjsonKey;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void produceJson(User user) {

        System.out.println(" Reading json user Object  " + user.toString());

        rabbitTemplate.convertAndSend(exchange, routingjsonKey, user);
    }
}
