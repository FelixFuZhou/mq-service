package com.zf.mqservice.service;

import com.zf.mqservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 作者  zhoufu
 * 日期  2017/5/26.
 */
@Component
public class RabbitMQCallbackSendService implements RabbitTemplate.ConfirmCallback{

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQCallbackSendService.class);

    @Autowired
    private RabbitTemplate rabbitTemplatenew;

    public void send1() {

        rabbitTemplatenew.setConfirmCallback(this);
        String msg="callbackSender : i am callback sender";
        System.out.println(msg );
        User user = new User();
        user.setLoginName("18550516525");
        user.setName("zhou");
        CorrelationData correlationData = new CorrelationData(user.getLoginName());
        System.out.println("callbackSender UUID: " + correlationData.getId());
        this.rabbitTemplatenew.convertAndSend("exchange", "topic.messages", msg, correlationData);
    }

    public void send2() {

        rabbitTemplatenew.setConfirmCallback(this);
        String msg="callbackSender : i am callback sender";
        System.out.println(msg );
        User user = new User();
        user.setLoginName("13915506121");
        user.setName("zhou2");
        CorrelationData correlationData = new CorrelationData(user.getLoginName());
        System.out.println("callbackSender UUID: " + correlationData.getId());
        this.rabbitTemplatenew.convertAndSend("exchange", "topic.messages", msg, correlationData);



    }

    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        // TODO Auto-generated method stub
        System.out.println("callbakck confirm: " + correlationData.getId());
    }
}
