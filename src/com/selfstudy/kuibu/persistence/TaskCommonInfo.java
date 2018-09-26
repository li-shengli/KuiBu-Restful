package com.selfstudy.kuibu.persistence;

import com.datastax.driver.mapping.annotations.Table;
import com.selfstudy.kuibu.constants.TaskFrom;
import com.selfstudy.kuibu.constants.TaskPriority;
import com.selfstudy.kuibu.constants.TaskStatus;
import com.selfstudy.kuibu.constants.TaskType;

import java.util.Date;
import java.util.UUID;

@Table(keyspace = "KuiBu", name = "taskCommonInfo", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class TaskCommonInfo {
    private UUID taskId;
    private String taskName;
    private TaskType taskType;
    private TaskStatus taskStatus;
    private TaskFrom taskFrom;
    private TaskPriority taskPriority;
    private Date createTime;
    private Date startTime;
    private Date endTime;

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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
