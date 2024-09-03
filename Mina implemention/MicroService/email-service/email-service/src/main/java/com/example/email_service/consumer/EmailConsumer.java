package com.example.email_service.consumer;

import com.example.email_service.model.OrderEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {



    @RabbitListener(queues = {"${rabbitMq.queue.email.name}"})
    public void getMessage(OrderEvent orderEvent)
    {


        System.err.println(" Reading the message from Stock Service "+orderEvent.toString());
    }

}
