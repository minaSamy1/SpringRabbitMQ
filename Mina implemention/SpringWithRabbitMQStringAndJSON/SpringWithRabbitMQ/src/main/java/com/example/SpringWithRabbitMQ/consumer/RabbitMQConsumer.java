package com.example.SpringWithRabbitMQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {


//    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
//    public void consume(String Message) {
//
//        System.out.println(" Counsumer Read Message >>>>>>>>>>>>>>> " + Message);
//    }
}
