package com.lindacare.messageconsumption.service;

import com.lindacare.messageconsumption.jms.producer.JmsMsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgConsumptionService {

    @Autowired
    private JmsMsgProducer jmsMsgProducer;

    public void addMarketDataToQueue(String marketData){
        if(marketData == null)
            return;

        jmsMsgProducer.send(marketData);
    }

}
