package com.selfstudy.kuibu.vo;

import com.selfstudy.kuibu.constants.TaskFrom;
import com.selfstudy.kuibu.constants.TaskPriority;
import com.selfstudy.kuibu.constants.TaskStatus;
import com.selfstudy.kuibu.constants.TaskType;
import com.selfstudy.kuibu.persistence.TaskCommonInfoEntity;
import com.selfstudy.kuibu.persistence.TaskReadingInfoEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TaskInfo {

    private UUID taskId;

    private String taskName;

    private TaskType taskType;

    private TaskStatus taskStatus;

    private TaskFrom taskFrom;

    private TaskPriority taskPriority;

    private Date createTime;

    private Date startTime;

    private Date lastUpdateTime;

    private Date endTime;

    private int pagesIntotal;

    private int pagesCurrent;

    private int expectedDays;

    private Map<Integer, Integer> history;

    public TaskCommonInfoEntity toTaskCommonInfoEntity () {
        TaskCommonInfoEntity commonInfoEntity = new TaskCommonInfoEntity();
        commonInfoEntity.setTaskId(this.taskId);
        commonInfoEntity.setTaskName(this.taskName);
        commonInfoEntity.setTaskType(this.taskType);
        commonInfoEntity.setCreateTime(this.createTime);
        return commonInfoEntity;
    }

    public TaskReadingInfoEntity toTaskReadingInfoEntity () {
        TaskReadingInfoEntity readingInfoEntity = new TaskReadingInfoEntity();
        readingInfoEntity.setTaskId(this.taskId);
        readingInfoEntity.setPagesIntotal(this.pagesIntotal);
        readingInfoEntity.setPagesCurrent(this.pagesCurrent);
        readingInfoEntity.setExpectedDays(this.expectedDays);
        if (this.history == null) {
            this.history = new HashMap<Integer, Integer>();
            this.history.put(0,0);
        }
        readingInfoEntity.setHistory(this.history);
        return readingInfoEntity;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TaskFrom getTaskFrom() {
        return taskFrom;
    }

    public void setTaskFrom(TaskFrom taskFrom) {
        this.taskFrom = taskFrom;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
