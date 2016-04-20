package io.pivotal.gemfire;

import io.pivotal.gemfire.template.CustomerOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ImportResource(value = "cache-config.xml")
public class PrototypeApplication {

	@Autowired
	CustomerOperations customerOperations;

	@PostConstruct
	public void run(){
		System.out.println("Running PrototypeApplication");
		customerOperations.run();
	}

	public static void main(String[] args) {
		SpringApplication.run(PrototypeApplication.class, args);
	}
}
