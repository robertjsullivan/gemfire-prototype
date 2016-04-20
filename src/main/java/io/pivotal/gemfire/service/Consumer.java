package io.pivotal.gemfire.service;

import io.pivotal.gemfire.template.EnvelopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pivotal on 4/20/16.
 */

@Component
public class Consumer {

    @Autowired
    EnvelopeService envelopeService;

    public void run(){
        System.out.println("Running consumer");

    }

}
