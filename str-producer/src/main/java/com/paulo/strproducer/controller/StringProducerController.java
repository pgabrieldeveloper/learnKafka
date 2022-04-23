package com.paulo.strproducer.controller;

import com.paulo.strproducer.services.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("str-producer")
@RequiredArgsConstructor
public class StringProducerController {

    private final StringProducerService service;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message){
        service.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
