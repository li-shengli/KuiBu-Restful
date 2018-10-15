package com.selfstudy.kuibu.service;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.Result;
import com.selfstudy.kuibu.constants.TaskType;
import com.selfstudy.kuibu.persistence.TaskCommonInfoEntity;
import com.selfstudy.kuibu.persistence.TaskReadingInfoEntity;
import com.selfstudy.kuibu.persistence.UserInfoEntity;
import com.selfstudy.kuibu.service.api.ITaskManageService;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.UUID;

public class TaskManageService extends AbstractService implements ITaskManageService {
    private static Logger logger = Logger.getLogger(TaskManageService.class);

    @Override
    public void addNewReadingTask(String username, TaskCommonInfoEntity commonInfo, TaskReadingInfoEntity details) {
        if(logger.isDebugEnabled()) {
            logger.debug("Create a new reading task.");
        }
        Mapper<TaskCommonInfoEntity> commonInfoEntityMapper = manager.mapper(TaskCommonInfoEntity.class);
        commonInfoEntityMapper.save(commonInfo);

        Mapper<TaskReadingInfoEntity> readingInfoEntityMapper = manager.mapper(TaskReadingInfoEntity.class);
        readingInfoEntityMapper.save(details);

        UserInfoEntity userInfoEntity = accessor.getUserInfo(username).one();
        userInfoEntity.getTasklist().add(commonInfo.getTaskId());
        Mapper<UserInfoEntity> userInfoEntityMapper = manager.mapper(UserInfoEntity.class);
        userInfoEntityMapper.save(userInfoEntity);
    }

    @Override
    public List<TaskCommonInfoEntity> getTaskList(String username) {
        if(logger.isDebugEnabled()) {
            logger.debug("Retrieve task list with user name: " + username);
        }
        UserInfoEntity userInfoEntity = accessor.getUserInfo(username).one();
        List<UUID> taskIds = userInfoEntity.getTasklist();

        Result<TaskCommonInfoEntity> commonInfoEntityResult = accessor.getTaskList(taskIds);
        return commonInfoEntityResult.all();
    }

    @Override
    public TaskCommonInfoEntity getTaskCommonInfo(UUID taskId) {
        if(logger.isDebugEnabled()) {
            logger.debug("Retrieve task common info with taskId: " + taskId);
        }
        return accessor.getTaskCommonInfo(taskId).one();
    }

    @Override
    public TaskReadingInfoEntity getReadingTaskDetails(UUID taskId) {
        if(logger.isDebugEnabled()) {
            logger.debug("Retrieve task details with taskId: " + taskId);
        }
        TaskReadingInfoEntity readingInfoEntity = accessor.getReadingTaskDetail(taskId).one();
        return readingInfoEntity;
    }

    @Override
    public void updateTask(TaskCommonInfoEntity commonInfoEntity, TaskReadingInfoEntity readingInfoEntity) {
        if(logger.isDebugEnabled()) {
            logger.debug("Update a existing reading task, taskId = " + commonInfoEntity.getTaskId());
        }
        Mapper<TaskCommonInfoEntity> commonInfoEntityMapper = manager.mapper(TaskCommonInfoEntity.class);
        commonInfoEntityMapper.save(commonInfoEntity);

        Mapper<TaskReadingInfoEntity> readingInfoEntityMapper = manager.mapper(TaskReadingInfoEntity.class);
        readingInfoEntityMapper.save(readingInfoEntity);
    }

    @Override
    public void deleteTask(String username, UUID taskId, TaskType taskType) {
        if(logger.isDebugEnabled()) {
            logger.debug("Delete a existing reading task, taskId = " + taskId);
        }
        if (TaskType.Reading.equals(taskType)) {
            Mapper<TaskReadingInfoEntity> readingInfoEntityMapper = manager.mapper(TaskReadingInfoEntity.class);
            readingInfoEntityMapper.delete(taskId);
        }
        Mapper<TaskCommonInfoEntity> commonInfoEntityMapper = manager.mapper(TaskCommonInfoEntity.class);
        commonInfoEntityMapper.delete(taskId);

        UserInfoEntity userInfoEntity = accessor.getUserInfo(username).one();
        userInfoEntity.getTasklist().remove(taskId);
        Mapper<UserInfoEntity> userInfoEntityMapper = manager.mapper(UserInfoEntity.class);
        userInfoEntityMapper.save(userInfoEntity);
    }


}
