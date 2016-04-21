package io.pivotal.gemfire.service;

import io.pivotal.gemfire.continuousQuery.CQSpringListener;
import io.pivotal.gemfire.domain.ContainerMetric;
import io.pivotal.gemfire.domain.Envelope;
import io.pivotal.gemfire.template.EnvelopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.gemfire.listener.ContinuousQueryDefinition;
import org.springframework.data.gemfire.listener.ContinuousQueryListenerContainer;
import org.springframework.data.gemfire.listener.adapter.ContinuousQueryListenerAdapter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by pivotal on 4/20/16.
 */

@Component
public class Producer implements Runnable {
    private final int STATISTICS_CHUNK = 100;
    private final int MAX_ENVELOPES = 500;

    private long envelopeCounter;
    private String randomIdentifier ="";

    @PostConstruct
    public void randomizeIdentifier(){
        char[] symbols;
        StringBuilder tmp = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            tmp.append(ch);
        }
        symbols = tmp.toString().toCharArray();


        SecureRandom random = new SecureRandom();
        int randomNumber = new BigInteger(15, random).intValue();
        while (randomNumber > 1){
            randomIdentifier += symbols[randomNumber % 10];
            randomNumber = randomNumber / 10;
        }

    }

    @Autowired
    EnvelopeService envelopeService;

    public void run(){
        System.out.println("Running Producer with random Identifier: "+randomIdentifier);
        long startTime = System.nanoTime();

        while(true && envelopeCounter < MAX_ENVELOPES){
            Envelope envelope = generateRandomEnvelope();
            envelopeService.insert(envelope);
            if(envelopeCounter % STATISTICS_CHUNK == 0) {
                long estimatedTime = System.nanoTime() - startTime;
                if(TimeUnit.NANOSECONDS.toMillis(estimatedTime) == 0){
                    System.out.println("Inserted "+STATISTICS_CHUNK+" envelopes at "+STATISTICS_CHUNK+" envelopes per millisecond.");
                }else {
                    System.out.println("Inserted "+STATISTICS_CHUNK+" envelopes at " + (new Float(STATISTICS_CHUNK)/ TimeUnit.NANOSECONDS.toMillis(estimatedTime)) + " envelopes per millisecond.");
                }
                startTime = System.nanoTime();
            }
        }

    }

    private Envelope generateRandomEnvelope() {
        String key  = randomIdentifier + new Long(envelopeCounter).toString();
        envelopeCounter++;
        String origin = "bob";
        String eventType = "myEventType";
        Date timestamp = Calendar.getInstance().getTime();
        String applicationId = "myAppID";
        int instanceIndex = 0;
        float cpuPercentage = 64.3f;
        long memoryBytes = 10000024L;
        long diskBytes = 100000000000024L;
        ContainerMetric containerMetric = new ContainerMetric( applicationId,  instanceIndex,  cpuPercentage,  memoryBytes,  diskBytes);
        return new Envelope(key,  origin,  eventType,  timestamp,  containerMetric);

    }
}
