package com.example.kafkaexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MessageController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/{message}")
    public ResponseEntity message(@PathVariable String message){
        kafkaTemplate.send("messageTopic", message);
        return ResponseEntity.ok().body(message);
    }
}
