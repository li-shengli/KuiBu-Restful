package com.selfstudy.kuibu.persistence;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.Map;
import java.util.UUID;

@Table(keyspace = "KuiBu", name = "taskReadingInfo", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class TaskReadingInfoEntity {
    @PartitionKey
    @Column(name = "taskId")
    private UUID taskId;

    @Column(name = "pagesIntotal")
    private int pagesIntotal;

    @Column(name = "pagesCurrent")
    private int pagesCurrent;

    @Column(name = "daystofinish")
    private int expectedDays;

    @Column(name = "history")
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
