package com.paulo.strcosumer.listeners;

import com.paulo.strcosumer.custom.StrConsumerCustomListner;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StrConsumerListner {

    @StrConsumerCustomListner(groupId = "grupo-1")
    @SneakyThrows
    public void crete(String message){
        log.info("CREATED ::: Menssagem Recebida: {}", message);
        throw new IllegalArgumentException("EXCEPTION...");
    }

    @StrConsumerCustomListner(groupId = "grupo-1")
    public void log(String message){
        log.info("LOG :::: Menssagem Recebida: {}", message);
    }

    @StrConsumerCustomListner(groupId = "grupo-2", containerFactory = "strContainerFactoryInterceptor")
    public void outro(String message){
        log.info("OUTRO :::: Menssagem Recebida: {}", message);
    }

}
