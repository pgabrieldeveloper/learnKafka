package com.paulo.strcosumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StrConsumerListner {


    @KafkaListener(groupId = "group-1", topicPartitions = {@TopicPartition(topic = "str-topic", partitions = {"1"})} , containerFactory = "strContainerFactory")
    public void crete(String message){
        log.info("CREATED ::: Menssagem Recebida: {}", message);
    }

    @KafkaListener(groupId = "group-1", topicPartitions = {@TopicPartition(topic = "str-topic", partitions = {"0"})}, containerFactory = "strContainerFactory")
    public void log(String message){
        log.info("LOG :::: Menssagem Recebida: {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainerFactory")
    public void outro(String message){
        log.info("OUTRO :::: Menssagem Recebida: {}", message);
    }

}
