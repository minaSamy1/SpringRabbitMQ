package com.example.order_service.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
@Value("${rabbitMq.queue.stock.name}")
private String stockQueue;


    @Value("${rabbitMq.queue.email.name}")
    private String emailQueue;

    @Value("${rabbitMq.exchange.name}")
    private String exhange;
    @Value("${rabbitMq.stock.routing.key}")
    private String stockRoutingKey;

    @Value("${rabbitMq.email.routing.key}")
    private String emailRoutingKey;
@Bean
    public Queue stockQueue()
    {


        return new Queue(stockQueue);
    }
    @Bean
    public Queue emailQueue()
    {


        return new Queue(emailQueue);
    }
    @Bean

    public TopicExchange exchange()
    {


        return new  TopicExchange(exhange);
    }

    @Bean   /// bind the exchange with stock queue
    public Binding bind()
    {


        return BindingBuilder.bind(stockQueue()).to(exchange()).with(stockRoutingKey);

    }


    @Bean   /// bind the exchange with stock queue
    public Binding bindemail()
    {


        return BindingBuilder.bind(emailQueue()).to(exchange()).with(emailRoutingKey);
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
