package com.example.SpringWithRabbitMQ.consumer;

import com.example.SpringWithRabbitMQ.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consume(User user) {

        System.out.println(" Counsumer Read Message >>>>>>>>>>>>>>> " + user.toString());
    }
}
