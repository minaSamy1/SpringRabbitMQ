package com.example.SpringWithRabbitMQ.Config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQconfig {

    @Value("${rabbitmq.queue.name}")
    private String queue;
    @Value("${rabbitmq.queue.json.name}")
    private String jsonQueue;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    @Value("${rabbitmq.routing.json.key}")
    private String routingjsonKey;

    @Bean  // creating binding
    public Queue queue() {

        return new Queue(queue);

    }

    @Bean  // creating Exchange
    public TopicExchange exchange() {

        return new TopicExchange(exchange);

    }


    @Bean   // create binding between the Queue and Exchange
    public Binding binding() {

        return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);

    }


    @Bean  /// this for create the new queue
    public Queue jsonQueue() {

        return new Queue(jsonQueue);
    }


    @Bean   // this for link between the exchange and json queue with key
    public Binding josnBinding() {

        return BindingBuilder.bind(jsonQueue()).to(exchange()).with(routingjsonKey);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}
