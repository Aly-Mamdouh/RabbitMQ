package com.rabbitmq.RabbitMQ.App.controller;

import com.rabbitmq.RabbitMQ.App.dto.User;
import com.rabbitmq.RabbitMQ.App.publisher.RabbitMQJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jsonapi")
public class MessageJsonController {
    private RabbitMQJsonProducer jsonProducer;

    @Autowired
    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("json message sent to rabbitMQ...");
    }
}
