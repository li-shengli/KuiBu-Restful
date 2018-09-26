package com.selfstudy.kuibu.persistence;

import com.datastax.driver.mapping.annotations.Table;

import java.util.Map;
import java.util.UUID;

@Table(keyspace = "KuiBu", name = "taskReadingInfo", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class TaskReadingInfo {
    private UUID taskId;
    private int pagesIntotal;
    private int pagesCurrent;
    private int expectedDays;
    private Map<Integer, Integer> history;

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    public int getPagesIntotal() {
        return pagesIntotal;
    }

    public void setPagesIntotal(int pagesIntotal) {
        this.pagesIntotal = pagesIntotal;
    }

    public int getPagesCurrent() {
        return pagesCurrent;
    }

    public void setPagesCurrent(int pagesCurrent) {
        this.pagesCurrent = pagesCurrent;
    }

    public int getExpectedDays() {
        return expectedDays;
    }

    public void setExpectedDays(int expectedDays) {
        this.expectedDays = expectedDays;
    }

    public Map<Integer, Integer> getHistory() {
        return history;
    }

    public void setHistory(Map<Integer, Integer> history) {
        this.history = history;
    }
}
