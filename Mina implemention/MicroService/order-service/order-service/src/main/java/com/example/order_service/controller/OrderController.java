package com.example.order_service.controller;

import com.example.order_service.model.Order;
import com.example.order_service.model.OrderEvent;
import com.example.order_service.publisher.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class OrderController {
    @Autowired
    private Producer p ;


    @PostMapping("/send")
    public String sendOrder(@RequestBody Order order)


    {

        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("Pending");
        orderEvent.setMessage(" order created");
        orderEvent.setOrder(order);
        p.send(orderEvent);
        return " Sending to Rabbit MQ ";

    }
}
