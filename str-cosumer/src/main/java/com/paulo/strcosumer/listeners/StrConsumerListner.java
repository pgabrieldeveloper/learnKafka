package com.paulo.strcosumer.listeners;

import com.paulo.strcosumer.custom.StrConsumerCustomListner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StrConsumerListner {

    @StrConsumerCustomListner(groupId = "grupo-1")
    public void crete(String message){
        log.info("CREATED ::: Menssagem Recebida: {}", message);
    }

    @StrConsumerCustomListner(groupId = "grupo-1")
    public void log(String message){
        log.info("LOG :::: Menssagem Recebida: {}", message);
    }

    @StrConsumerCustomListner(groupId = "grupo-2")
    public void outro(String message){
        log.info("OUTRO :::: Menssagem Recebida: {}", message);
    }

}
