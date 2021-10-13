package com.phisoft.springbootkafkaproducerone.controller;

import com.phisoft.springbootkafkaproducerone.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class PublishController {

    @Autowired
    private KafkaTemplate<String, Book>kafkaTemplate;
    private static final String TOPIC="quickstart-events";

    @PostMapping("/publish")
    public String publishedMessage(@RequestBody Book book){
        kafkaTemplate.send(TOPIC,book);
        return "Published successfully";
    }

}
