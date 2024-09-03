package com.example.SpringWithRabbitMQ.Controller;


import com.example.SpringWithRabbitMQ.publisher.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    @Autowired
    private RabbitMqProducer rabbitMqProducer;

    @GetMapping("publish")
    public ResponseEntity<String> send(@RequestParam  String message)
    {

        System.out.println(" Here in Controller Api >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        rabbitMqProducer.send(message);
        return  ResponseEntity.ok(" Message Send to Rabbit MQ" );

    }
}
