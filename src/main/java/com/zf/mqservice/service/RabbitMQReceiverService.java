package com.zf.mqservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 作者  zhoufu
 * 日期  2017/5/25.
 */
@Component
public class RabbitMQReceiverService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQReceiverService.class);

    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void process(String msg){
        LOGGER.info("receiver1 msg :"+msg);
    }


    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void process2(String msg){
        LOGGER.info("receiver2 msg :"+msg);
    }
}
