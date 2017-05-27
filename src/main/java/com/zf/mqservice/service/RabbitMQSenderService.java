package com.zf.mqservice.service;

import com.zf.mqservice.model.User;
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

        User user = new User();
        user.setLoginName("18550516525");
        user.setName("zhou");
        LOGGER.info("send test :"+ user.getLoginName());

        this.amqpTemplate.convertAndSend("hello",user);


    }

    public void send(String msg){
        LOGGER.info("send test :"+msg);
        this.amqpTemplate.convertAndSend("hello",msg);


    }

    public void sendTopic(){
        String topicMsg = "I am topic msg ";
        LOGGER.info("send topic msg :"+topicMsg);
        this.amqpTemplate.convertAndSend("exchange","topic.message",topicMsg);
    }

    public void sendTopicS(){
        String topicMsgs = "I am topic msg s";
        LOGGER.info("send topic msgs :"+topicMsgs);

        this.amqpTemplate.convertAndSend("exchange","topic.messages",topicMsgs);
    }

    public void sendFant(){
        String FantMsg = "i am Fant msg";
        LOGGER.info("send fant msg :"+FantMsg);
        this.amqpTemplate.convertAndSend("fanoutExchange","1111",FantMsg);
    }
}
