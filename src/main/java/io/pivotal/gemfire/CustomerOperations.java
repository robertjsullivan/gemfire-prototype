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

import org.springframework.data.gemfire.GemfireOperations;

import com.gemstone.gemfire.cache.query.SelectResults;
import java.util.List;


public class CustomerOperations {
    private static Log log = LogFactory.getLog(CustomerOperations.class);

   GemfireOperations customerTemplate;

    public void setCustomerTemplate(GemfireOperations myTemplate){
        System.out.println("Injecting Template &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        customerTemplate = myTemplate;
    }

    /**
     * run the example
     */
    public void run() {
        System.out.println("Running my ops**************************************************************************************");
        //createCustomers();
        searchCustomers();
        //deleteCustomers();
    }

    /*
     * create some customers
     */
    private void createCustomers() {
        //Customer dave = new Customer(1L,new EmailAddress("dave@matthews.com"),"Dave","Matthews");
        //Customer alicia = new Customer(2L,new EmailAddress("alicia@keys.com"),"Alicia","Keys");
        System.out.println("CustomerTemplate: "+customerTemplate);

        customerTemplate.put(1L, "dave");
        customerTemplate.put(2l, "alicia");
    }

    /*
     * Retrieve customers
     */
    private void searchCustomers() {
        SelectResults<Object> jSonDave = customerTemplate.find("select * from /customer");
        System.out.println("Customers: "+jSonDave);
    }

    /*
     * Delete customers
     */
    private void deleteCustomers() {
        //customerTemplate.remove(1L);
        //customerTemplate.remove(2L);
    }
}