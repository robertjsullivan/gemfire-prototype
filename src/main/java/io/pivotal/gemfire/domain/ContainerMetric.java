package io.pivotal.gemfire.domain;

import java.io.Serializable;

/**
 * Created by pivotal on 4/20/16.
 */
public class ContainerMetric implements Serializable {
    private String applicationId;
    private int instanceIndex;
    private float cpuPercentage;
    private long memoryBytes;
    private long diskBytes;

    public ContainerMetric(String applicationId, int instanceIndex, float cpuPercentage, long memoryBytes, long diskBytes) {
        this.applicationId = applicationId;
        this.instanceIndex = instanceIndex;
        this.cpuPercentage = cpuPercentage;
        this.memoryBytes = memoryBytes;
        this.diskBytes = diskBytes;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public int getInstanceIndex() {
        return instanceIndex;
    }

    public void setInstanceIndex(int instanceIndex) {
        this.instanceIndex = instanceIndex;
    }

    public float getCpuPercentage() {
        return cpuPercentage;
    }

    public void setCpuPercentage(float cpuPercentage) {
        this.cpuPercentage = cpuPercentage;
    }

    public long getMemoryBytes() {
        return memoryBytes;
    }

    public void setMemoryBytes(long memoryBytes) {
        this.memoryBytes = memoryBytes;
    }

    public long getDiskBytes() {
        return diskBytes;
    }

    public void setDiskBytes(long diskBytes) {
        this.diskBytes = diskBytes;
    }
}
