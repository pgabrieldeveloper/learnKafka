package com.paulo.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("str-topic", message).addCallback(
                success -> {
                    if(success != null){
                        log.info("Menssagem enviado com sucesso");
                        log.info("Partition: {} OffSet: {}", success.getRecordMetadata().partition(), success.getRecordMetadata().partition());
                    }
                },
                error -> {
                    log.error("Error ao enviar menssagem: {}", error.getMessage());
                }
        );
    }

}
