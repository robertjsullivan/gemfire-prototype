package io.pivotal.gemfire.monitor;


import org.springframework.stereotype.Component;
import io.pivotal.gemfire.domain.Envelope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pivotal on 4/22/16.
 */

@Component
public class Repository {

private Map<String, Envelope> continuousQueryResults = new ConcurrentHashMap<String, Envelope>();

    public void addQueryResult(Envelope envelope){
        continuousQueryResults.put(envelope.getKey(), envelope);
    }

    public List<Envelope> getAllQueryResults(){
        return (List<Envelope>) continuousQueryResults.values();
    }

    public Envelope getQueryResult(String key){
        return continuousQueryResults.get(key);
    }

}
