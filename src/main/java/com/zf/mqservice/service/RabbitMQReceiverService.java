package com.zf.mqservice.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.zf.mqservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import sun.font.TrueTypeFont;

import java.io.IOException;

/**
 * 作者  zhoufu
 * 日期  2017/5/25.
 */
@Component
public class RabbitMQReceiverService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQReceiverService.class);

    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void process(User user, Channel channel , @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
//       返回接受成功
        channel.basicAck(tag,false);

        LOGGER.info("receiver1 msg :"+user.getLoginName());
    }


    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void process2(User user, Channel channel ,@Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {

        //       返回接受失败  2中方式
        channel.basicNack(tag,false, true);
//        channel.basicReject(tag, true);

        LOGGER.info("receiver2 msg :"+user.getLoginName());
    }

    @RabbitListener(queues = "topic.message")
    @RabbitHandler()
    public void topicProcess(String msg, Channel channel, Message message) throws IOException {

        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//        channel.basicPublish(message.getMessageProperties().getReceivedExchange(),
//                message.getMessageProperties().getReceivedRoutingKey(), MessageProperties.TEXT_PLAIN,
//                JSON.toJSONBytes(msg));
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
