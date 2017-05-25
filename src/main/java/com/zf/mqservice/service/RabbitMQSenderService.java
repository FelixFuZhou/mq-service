package com.zf.mqservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 作者  zhoufu
 * 日期  2017/5/25.
 */
@Component
public class RabbitMQSenderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQSenderService.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String sendmsg = "hello "+new Date();
        LOGGER.info("send test :"+sendmsg);

        this.amqpTemplate.convertAndSend("hello",sendmsg);


    }

    public void send(String msg){
        LOGGER.info("send test :"+msg);
        this.amqpTemplate.convertAndSend("hello",msg);


    }
}
