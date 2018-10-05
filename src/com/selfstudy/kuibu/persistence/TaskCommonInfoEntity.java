package com.selfstudy.kuibu.persistence;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.selfstudy.kuibu.constants.TaskFrom;
import com.selfstudy.kuibu.constants.TaskPriority;
import com.selfstudy.kuibu.constants.TaskStatus;
import com.selfstudy.kuibu.constants.TaskType;
import com.selfstudy.kuibu.vo.TaskInfo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.UUID;

@Table(keyspace = "KuiBu", name = "taskCommonInfo", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class TaskCommonInfoEntity {
    @PartitionKey
    @Column(name = "taskId")
    private UUID taskId;

    @Column(name = "taskName")
    private String taskName;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "taskType")
    private TaskType taskType;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "taskStatus")
    private TaskStatus taskStatus;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "taskFrom")
    private TaskFrom taskFrom;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "priority")
    private TaskPriority taskPriority;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "startTime")
    private Date startTime;

    @Column(name = "lastUpdateTime")
    private Date lastUpdateTime;

    @Column(name = "endTime")
    private Date endTime;

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public TaskInfo toTaskInfo() {
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setTaskId(this.taskId);
        taskInfo.setTaskName(this.taskName);
        taskInfo.setTaskType(this.taskStatus.ordinal());
        return taskInfo;
    }
}
