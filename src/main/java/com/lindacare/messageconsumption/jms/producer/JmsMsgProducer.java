package com.lindacare.messageconsumption.jms.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsMsgProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jsa.activemq.queue}")
    private String queue;

    public void send(String msg){
        jmsTemplate.convertAndSend(queue, msg);
    }
}
