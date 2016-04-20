package io.pivotal.gemfire.template;

import com.gemstone.gemfire.cache.query.SelectResults;
import io.pivotal.gemfire.domain.Envelope;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.gemfire.GemfireOperations;
import org.springframework.stereotype.Component;

/**
 * Created by pivotal on 4/20/16.
 */
@Component
public class EnvelopeService {
    private static Log log = LogFactory.getLog(EnvelopeService.class);

    @Autowired
    GemfireOperations envelopeTemplate;

    public void insert(Envelope envelope){
        envelopeTemplate.put(envelope.getKey(), envelope);

    }

    public SelectResults<Object> query(String query){
        return envelopeTemplate.find(query);
    }
//
//    /*
//     * create some customers
//     */
//    private void createCustomers() {
//        Customer bob = new Customer(1L,"bob", "dave@matthews.com");
//        Customer tom = new Customer(2L,"tom", "alicia@keys.com");
//        customerTemplate.put(1L, bob);
//        customerTemplate.put(2l, tom);
//    }
//
//    /*
//     * Retrieve customers
//     */
//    private void searchCustomers() {
//        SelectResults<Object> searchResults = customerTemplate.find("select * from /customer");
//        for(Object obj: searchResults){
//            Customer customer = (Customer) obj;
//            System.out.println("Name: "+customer.getName());
//        }
//    }
//
//    /*
//     * Delete customers
//     */
//    private void deleteCustomers() {
//        customerTemplate.remove(1L);
//        customerTemplate.remove(2L);
//    }
}