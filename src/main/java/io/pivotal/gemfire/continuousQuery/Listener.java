package io.pivotal.gemfire.continuousQuery;

import com.gemstone.gemfire.cache.query.CqEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.gemfire.listener.ContinuousQueryListener;
import org.springframework.data.gemfire.listener.adapter.ContinuousQueryListenerAdapter;

/**
 * Created by pivotal on 4/20/16.
 */
public class Listener {
    private static Log log = LogFactory.getLog(Listener.class);

    public void handleEvent(CqEvent event) {
        log.info("Received a CQ event " + event);
        System.out.println("I got an event!!!!!! YAY!!!!");
    }

}
