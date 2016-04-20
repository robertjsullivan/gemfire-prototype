package io.pivotal.gemfire;

import io.pivotal.gemfire.continuousQuery.Container;
import io.pivotal.gemfire.service.Consumer;
import io.pivotal.gemfire.service.Producer;
import io.pivotal.gemfire.template.EnvelopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.listener.ContinuousQueryListenerContainer;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ImportResource(value = "cache-config.xml")
public class PrototypeApplication {

	@Autowired
	EnvelopeService envelopeService;

    @Autowired
    Producer producer;

    @Autowired
    Consumer consumer;

    //@Autowired
    //ContinuousQueryListenerContainer continuousQueryListenerContainer;

    //@Autowired
    //Container container;

    @PostConstruct
	public void run(){
		System.out.println("Running PrototypeApplication");
       // ContinuousQueryListenerContainer continuousQueryListenerContainer = container.continuousQueryListenerContainer();
		new Thread(producer).start();
        new Thread(consumer).start();
        //continuousQueryListenerContainer.stop();
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PrototypeApplication.class);
		app.run(args);
	}
}
