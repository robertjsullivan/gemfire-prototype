package io.pivotal.gemfire.rest;

import io.pivotal.gemfire.monitor.*;
import io.pivotal.gemfire.monitor.Repository;
import io.pivotal.gemfire.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import io.pivotal.gemfire.domain.Envelope;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
public class Controller {

    @Autowired
    Producer producer;

    @Autowired
    GemfireInsertRate gemfireInsertRate;

    @Autowired
    Repository repository;

    @RequestMapping("/run")
    String home(@RequestParam(required = true) long count) {
        System.out.println("Running via REST");

        try {
            return "Your rates were: " + producer.run(count);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "An error occurred";
    }

    @RequestMapping("/sentinel")
    String sendSentinel() {
        Envelope envelope = null;

        try {
            envelope = producer.sendSentinel();


        }catch(Exception e){
            e.printStackTrace();
            return "An error occurred";
        }
        if(envelope != null) {
            return "Event delay was " + (envelope.getContinousQueryReceivedTimestamp().getTime() - envelope.getTimestamp().getTime()) + " ms";
        }else{
            return "Gave up waiting for the continuous query to pop.";
        }

    }

    @RequestMapping("/once")
    String once() {
        System.out.println("Running via REST");


        return "Your rates were: " + producer.run(1);
    }

    @RequestMapping("/insertRate")
    String getInsertRate(){
        return gemfireInsertRate.monitor();
    }


}