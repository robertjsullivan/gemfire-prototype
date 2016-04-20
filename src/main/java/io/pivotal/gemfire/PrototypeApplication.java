package io.pivotal.gemfire;

import io.pivotal.gemfire.service.Consumer;
import io.pivotal.gemfire.service.Producer;
import io.pivotal.gemfire.template.EnvelopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ImportResource;

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

	@PostConstruct
	public void run(){
		System.out.println("Running PrototypeApplication");
		producer.run();
        //consumer.run();
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PrototypeApplication.class);
		app.run(args);
	}
}
