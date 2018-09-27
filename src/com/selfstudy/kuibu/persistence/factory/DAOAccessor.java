package com.selfstudy.kuibu.persistence.factory;

import java.util.List;
import java.util.UUID;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import com.selfstudy.kuibu.persistence.*;

@Accessor
public interface DAOAccessor {

	@Query("SELECT * FROM kuibu.userInformation where longinName=?")
	Result<UserInfoEntity> getUserInfo(String loginName);

	Result<TaskCommonInfo> getTaskList(List<UUID> taskIds);
}
