package io.pivotal.gemfire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.gemfire.GemfireOperations;
import org.springframework.stereotype.Component;

import org.springframework.data.gemfire.GemfireTemplate;

import com.gemstone.gemfire.cache.query.SelectResults;

@SpringBootApplication
public class PrototypeApplication {

	public static void main(String[] args) {

		System.out.println("here");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		SpringApplication.run(PrototypeApplication.class, args);

        CustomerOperations ops = (CustomerOperations) context.getBean("customerOperations");
        ops.run();
		System.out.println("done");
	}
}
