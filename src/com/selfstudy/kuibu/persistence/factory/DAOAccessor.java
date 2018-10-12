package com.selfstudy.kuibu.persistence.factory;

import java.util.List;
import java.util.UUID;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import com.selfstudy.kuibu.persistence.*;

@Accessor
public interface DAOAccessor {

	@Query("SELECT * FROM kuibu.userInformation where longinname = ?")
	Result<UserInfoEntity> getUserInfo(String loginName);

	@Query("SELECT * FROM kuibu.taskCommonInfo where taskId in ?")
	Result<TaskCommonInfoEntity> getTaskList(List<UUID> taskIds);

	@Query("SELECT * FROM kuibu.taskReadingInfo where taskId = ?")
	Result<TaskReadingInfoEntity> getReadingTaskDetail(UUID taskId);
}
