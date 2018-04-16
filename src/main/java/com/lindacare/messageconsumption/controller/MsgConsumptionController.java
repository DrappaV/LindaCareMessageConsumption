package com.lindacare.messageconsumption.controller;

import com.lindacare.messageconsumption.service.MsgConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgConsumptionController {


    public MsgConsumptionController(){ }

    @Autowired
    private MsgConsumptionService msgConsumptionService;

    @RequestMapping(value="/addMarketModel" , method= RequestMethod.POST)
    public String addToQueue(@RequestBody String marketModel) {
        msgConsumptionService.addMarketDataToQueue(marketModel);
        return "ok";
    }

}