package com.selfstudy.kuibu.restful;

import com.selfstudy.kuibu.constants.TaskStatus;
import com.selfstudy.kuibu.constants.TaskType;
import com.selfstudy.kuibu.persistence.TaskCommonInfoEntity;
import com.selfstudy.kuibu.persistence.TaskReadingInfoEntity;
import com.selfstudy.kuibu.service.api.ITaskManageService;
import com.selfstudy.kuibu.vo.TaskInfo;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.*;

@Path("/")
@Produces({ "text/xml", "application/json" })
public class TaskRestService {
    private static Logger logger = Logger.getLogger(TaskRestService.class);

    @Inject
    private ITaskManageService taskService;

    @Path("/task/add")
    @POST
    @Produces("application/json")
    public void addNewTask(TaskInfo taskInfo) {
        if(logger.isDebugEnabled()) {
            logger.debug("Create New Task! TaskInfo: "+ taskInfo.toString());
        }
        Date createTime = new Date();
        taskInfo.setTaskId(UUID.randomUUID().toString());
        taskInfo.setCreateTime(createTime);

        TaskCommonInfoEntity commonInfoEntity = taskInfo.toTaskCommonInfoEntity();
        commonInfoEntity.setTaskStatus(TaskStatus.Submitted);

        if (TaskType.Reading.name().equals(taskInfo.getTaskType())) {
            if(logger.isDebugEnabled()) {
                logger.debug("Create New Reading Task!");
            }
            TaskReadingInfoEntity readingInfoEntity = taskInfo.toTaskReadingInfoEntity();
            taskService.addNewReadingTask(taskInfo.getUsername(), commonInfoEntity, readingInfoEntity);
        }
    }

    @Path("/task/all/{username}")
    @GET
    @Produces("application/json")
    public Map<Integer, List<TaskInfo>> getTaskList(@PathParam("username") String username) {
        List<TaskCommonInfoEntity> commonInfoEntities = taskService.getTaskList(username);

        Map<Integer, List<TaskInfo>> tasks = new HashMap<>();
        List<TaskInfo> submittedTasks = new ArrayList<>();
        tasks.put(TaskStatus.Submitted.ordinal(), submittedTasks);
        List<TaskInfo> ongoingTasks = new ArrayList<>();
        tasks.put(TaskStatus.Executing.ordinal(), ongoingTasks);
        List<TaskInfo> doneTasks = new ArrayList<>();
        tasks.put(TaskStatus.Finished.ordinal(), doneTasks);

        for (TaskCommonInfoEntity commonInfoEntity : commonInfoEntities) {
            TaskReadingInfoEntity readingInfoEntity = taskService.getReadingTaskDetails(commonInfoEntity.getTaskId());
            TaskInfo taskInfo = new TaskInfo(commonInfoEntity, readingInfoEntity);
            if(TaskStatus.Submitted.equals(commonInfoEntity.getTaskStatus())) {
                submittedTasks.add(taskInfo);
            } else if (TaskStatus.Executing.equals(commonInfoEntity.getTaskStatus())) {
                ongoingTasks.add(taskInfo);
            } else if (TaskStatus.Finished.equals(commonInfoEntity.getTaskStatus())) {
                doneTasks.add(taskInfo);
            } else {
                // todo
            }
        }

        return tasks;
    }

    @Path("/task/updateReadingTask")
    @POST
    @Produces("application/json")
    public void updateReadingTask(TaskInfo taskInfo) {
        if (logger.isDebugEnabled()) {
            logger.debug("Update a task, taskId = "+ taskInfo.getTaskId());
        }
        TaskCommonInfoEntity commonInfoEntity = taskService.getTaskCommonInfo(UUID.fromString(taskInfo.getTaskId()));
        TaskReadingInfoEntity readingInfoEntity = taskService.getReadingTaskDetails(UUID.fromString(taskInfo.getTaskId()));

        if (commonInfoEntity == null || readingInfoEntity == null) {
            throw new IllegalStateException("Specific Task Not Found, taskId = " + taskInfo.getTaskId());
        }

        taskInfo.updateTaskCommonInfoEntity(commonInfoEntity);
        taskInfo.updateTaskReadingInfoEntity(commonInfoEntity, readingInfoEntity);

        taskService.updateTask(commonInfoEntity, readingInfoEntity);
    }

    @Path("/task/delete/{username}/{taskType}/{taskId}")
    @GET
    @Produces("application/json")
    public void deleteTask(@PathParam("username") String username, @PathParam("taskType") int type, @PathParam("taskId") String taskId) {
        if (logger.isDebugEnabled()) {
            logger.debug("Delete a task, taskId = "+ taskId + "; type = "+type);
        }
        TaskType taskType = TaskType.values()[type];

        taskService.deleteTask(username, UUID.fromString(taskId), taskType);
    }
}
