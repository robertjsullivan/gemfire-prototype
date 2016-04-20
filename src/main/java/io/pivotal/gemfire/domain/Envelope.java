package io.pivotal.gemfire.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by pivotal on 4/20/16.
 */
public class Envelope implements Serializable{


    private String key;
    private String origin;
    private String eventType;
    private Date timestamp;

    private ContainerMetric containerMetric;

    public Envelope(String key, String origin, String eventType, Date timestamp, ContainerMetric containerMetric) {
        this.key = key;
        this.origin = origin;
        this.eventType = eventType;
        this.timestamp = timestamp;
        this.containerMetric = containerMetric;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ContainerMetric getContainerMetric() {
        return containerMetric;
    }

    public void setContainerMetric(ContainerMetric containerMetric) {
        this.containerMetric = containerMetric;
    }
}
