package com.zf.mqservice.api;

import com.zf.mqservice.service.RabbitMQCallbackSendService;
import com.zf.mqservice.service.RabbitMQSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者  zhoufu
 * 日期  2017/5/25.
 */
@RestController
@RequestMapping(value = "rabbitmq")
public class RabbitMQController {

    @Autowired
    private RabbitMQSenderService rabbitMQSenderService;
    @Autowired
    private RabbitMQCallbackSendService rabbitMQCallbackSendService;

    /**
     *发送单条
     *@Author: zhoufu
     *@param:
     *@return:
     */
    @RequestMapping(value = "send",method = RequestMethod.GET)
    public void sendMsg(){
        rabbitMQSenderService.send();
    }

    @RequestMapping(value = "sends",method = RequestMethod.GET)
    public void sendMsgs(){
        for(int i= 0 ;i<10 ; i++){
            rabbitMQSenderService.send("helloMsg"+i);
        }
    }

    @RequestMapping(value = "sendTopic",method = RequestMethod.GET)
    public void sendTopicMsgs(){
        rabbitMQSenderService.sendTopic();
//        rabbitMQSenderService.sendTopicS();
    }

    @RequestMapping(value = "sendFant",method = RequestMethod.GET)
    public void sendFantMsgs(){
        rabbitMQSenderService.sendFant();
    }

    @RequestMapping(value = "sendCallback",method = RequestMethod.GET)
    public void sendCallMsgs(){
        rabbitMQCallbackSendService.send1();
        rabbitMQCallbackSendService.send2();
    }

}
