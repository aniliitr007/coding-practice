package com.akgcloud.java.application.jmx;

public class SystemConfig implements SystemConfigMBean {

    public int    m_threadCount;
    public String m_schemaName;
    public int m_count;

    public SystemConfig(int numThreads, String schema) {
        this.m_threadCount = numThreads;
        this.m_schemaName = schema;
    }

    public void setThreadCount(int noOfThreads) {
        this.m_threadCount = noOfThreads;
    }

    public int getThreadCount() {
        return this.m_threadCount;
    }

    public void setSchemaName(String schemaName) {
        this.m_schemaName = schemaName;
    }

    public String getSchemaName() {
        return this.m_schemaName;
    }

    public String doConfig() {
        return "No of Threads=" + this.m_threadCount + " and DB Schema Name=" + this.m_schemaName;
    }

}