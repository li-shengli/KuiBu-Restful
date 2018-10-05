package com.selfstudy.kuibu.service.api;

import com.selfstudy.kuibu.persistence.TaskCommonInfoEntity;
import com.selfstudy.kuibu.persistence.TaskReadingInfoEntity;

import java.util.List;

public interface ITaskManageService {
    void addNewReadingTask(String username, TaskCommonInfoEntity commonInfo, TaskReadingInfoEntity details);

    List<TaskCommonInfoEntity> getTaskList(String username);
}
