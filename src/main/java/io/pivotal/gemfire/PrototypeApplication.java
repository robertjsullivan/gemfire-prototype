package io.pivotal.gemfire;

import com.sun.media.jfxmedia.logging.Logger;
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
import java.util.logging.Level;

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
        String[] loggers = { "org.springframework"};
        for (String ln : loggers) {
            // Try java.util.logging as backend
            java.util.logging.Logger.getLogger(ln).setLevel(Level.FINEST);

            // Try Log4J as backend
            org.apache.log4j.Logger.getLogger(ln).setLevel(org.apache.log4j.Level.TRACE);

        }
       // ContinuousQueryListenerContainer continuousQueryListenerContainer = container.continuousQueryListenerContainer();
		//new Thread(producer).start();
        //new Thread(consumer).start();
        //continuousQueryListenerContainer.stop();
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PrototypeApplication.class);
		app.run(args);
	}
}
