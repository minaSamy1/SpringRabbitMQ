package com.example.Stock_service.consumer;

import com.example.Stock_service.model.OrderEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StockConsumer {


    @RabbitListener(queues = {"${rabbitMq.queue.stock.name}"})
    public void getMessage(OrderEvent orderEvent) {


        System.err.println(" Reading the message from Stock Service " + orderEvent.toString());
    }

}
