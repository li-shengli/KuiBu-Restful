package com.selfstudy.kuibu.service.api;

import com.selfstudy.kuibu.constants.TaskType;
import com.selfstudy.kuibu.persistence.TaskCommonInfoEntity;
import com.selfstudy.kuibu.persistence.TaskReadingInfoEntity;

import java.util.List;
import java.util.UUID;

public interface ITaskManageService {
    void addNewReadingTask(String username, TaskCommonInfoEntity commonInfo, TaskReadingInfoEntity details);

    List<TaskCommonInfoEntity> getTaskList(String username);

    TaskCommonInfoEntity getTaskCommonInfo(UUID taskId);

    TaskReadingInfoEntity getReadingTaskDetails(UUID taskId);

    void updateTask(TaskCommonInfoEntity commonInfoEntity, TaskReadingInfoEntity readingInfoEntity);

    void deleteTask(String username, UUID taskId, TaskType taskType);
}
