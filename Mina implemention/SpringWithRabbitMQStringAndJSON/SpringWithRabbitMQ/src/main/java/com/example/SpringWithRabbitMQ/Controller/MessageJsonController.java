package com.example.SpringWithRabbitMQ.Controller;

import com.example.SpringWithRabbitMQ.dto.User;
import com.example.SpringWithRabbitMQ.publisher.RabbitMqJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class MessageJsonController {

    @Autowired
    private RabbitMqJsonProducer rabbitMqJsonProducer;


    @PostMapping("/publish")
    public ResponseEntity<String> sendJson(@RequestBody User user) {


        rabbitMqJsonProducer.produceJson(user);
        return ResponseEntity.ok("Message Sent to RabbitMQ..........");
    }
}
