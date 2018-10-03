package com.selfstudy.kuibu.restful;

import com.selfstudy.kuibu.constants.TaskType;
import com.selfstudy.kuibu.persistence.TaskCommonInfoEntity;
import com.selfstudy.kuibu.persistence.TaskReadingInfoEntity;
import com.selfstudy.kuibu.service.api.ITaskManageService;
import com.selfstudy.kuibu.vo.TaskInfo;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Date;
import java.util.UUID;

@Path("/")
@Produces({ "text/xml", "application/json" })
public class TaskRestService {
    private static Logger logger = Logger.getLogger(UserRestService.class);

    @Inject
    private ITaskManageService taskService;

    @Path("/task/add")
    @POST
    @Produces("application/json")
    public void addNewTask(TaskInfo taskInfo) {
        Date createTime = new Date();
        taskInfo.setTaskId(UUID.randomUUID());
        taskInfo.setCreateTime(createTime);

        TaskCommonInfoEntity commonInfoEntity = taskInfo.toTaskCommonInfoEntity();

        if (TaskType.Reading.equals(taskInfo.getTaskType())) {
            TaskReadingInfoEntity readingInfoEntity = taskInfo.toTaskReadingInfoEntity();

            taskService.addNewReadingTask(commonInfoEntity, readingInfoEntity);
        }
    }
}
