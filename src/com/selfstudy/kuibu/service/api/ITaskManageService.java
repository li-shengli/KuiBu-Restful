package com.selfstudy.kuibu.service.api;

import com.selfstudy.kuibu.persistence.TaskCommonInfoEntity;
import com.selfstudy.kuibu.persistence.TaskReadingInfoEntity;

public interface ITaskManageService {
    void addNewReadingTask(TaskCommonInfoEntity commonInfo, TaskReadingInfoEntity details);
}
