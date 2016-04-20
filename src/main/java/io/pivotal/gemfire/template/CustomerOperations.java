package io.pivotal.gemfire.template;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.GemfireOperations;

import com.gemstone.gemfire.cache.query.SelectResults;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerOperations {
    private static Log log = LogFactory.getLog(CustomerOperations.class);

    @Autowired
    GemfireOperations customerTemplate;

    /**
     * run the example
     */
    public void run() {
        createCustomers();
        searchCustomers();
        //deleteCustomers();
    }

    /*
     * create some customers
     */
    private void createCustomers() {
        //Customer dave = new Customer(1L,new EmailAddress("dave@matthews.com"),"Dave","Matthews");
        //Customer alicia = new Customer(2L,new EmailAddress("alicia@keys.com"),"Alicia","Keys");
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