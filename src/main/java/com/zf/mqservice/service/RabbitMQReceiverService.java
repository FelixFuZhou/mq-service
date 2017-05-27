package com.zf.mqservice.service;

import com.zf.mqservice.model.User;
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
    public void process(User user){
        LOGGER.info("receiver1 msg :"+user.getLoginName());
    }


    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void process2(User user){
        LOGGER.info("receiver2 msg :"+user.getLoginName());
    }

    @RabbitListener(queues = "topic.message")
    @RabbitHandler()
    public void topicProcess(String msg){
        LOGGER.info("topic receiver msg :"+msg);
    }

    @RabbitListener(queues = "topic.messages")
    @RabbitHandler()
    public void topicsProcess(String msg){
        LOGGER.info("topics receiver msg:"+msg);
    }

    @RabbitListener(queues = "fanout.A")
    @RabbitHandler()
    public void fantAProcess(String msg){
        LOGGER.info("fant A receiver msg:"+msg);
    }


    @RabbitListener(queues = "fanout.B")
    @RabbitHandler()
    public void fantBProcess(String msg){
        LOGGER.info("fant B receiver msg:"+msg);
    }


    @RabbitListener(queues = "fanout.C")
    @RabbitHandler()
    public void fantCProcess(String msg){
        LOGGER.info("fant C receiver msg:"+msg);
    }


}
