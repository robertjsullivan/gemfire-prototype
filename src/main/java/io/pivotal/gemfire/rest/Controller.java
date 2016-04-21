package io.pivotal.gemfire.rest;

import io.pivotal.gemfire.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    Producer producer;

    @RequestMapping("/run")
    String home(@RequestParam(required = true) int count) {
        System.out.println("Running via REST");


        return "Your rates were: " + producer.run(count);
    }
}