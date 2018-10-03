package com.selfstudy.kuibu.service;

import com.datastax.driver.mapping.Mapper;
import com.selfstudy.kuibu.persistence.TaskCommonInfoEntity;
import com.selfstudy.kuibu.persistence.TaskReadingInfoEntity;
import com.selfstudy.kuibu.persistence.UserInfoEntity;
import com.selfstudy.kuibu.service.api.ITaskManageService;

public class TaskManageService extends AbstractService implements ITaskManageService {
    @Override
    public void addNewReadingTask(TaskCommonInfoEntity commonInfo, TaskReadingInfoEntity details) {
        Mapper<TaskCommonInfoEntity> commonInfoEntityMapper = manager.mapper(TaskCommonInfoEntity.class);
        commonInfoEntityMapper.save(commonInfo);

        Mapper<TaskReadingInfoEntity> readingInfoEntityMapper = manager.mapper(TaskReadingInfoEntity.class);
        readingInfoEntityMapper.save(details);
    }
}
