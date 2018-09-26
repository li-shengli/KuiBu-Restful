package com.selfstudy.kuibu.persistence.factory;

import java.util.UUID;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import com.selfstudy.kuibu.persistence.ActivityEntity;
import com.selfstudy.kuibu.persistence.ColleagueEntity;
import com.selfstudy.kuibu.persistence.GroupEntity;
import com.selfstudy.kuibu.persistence.TeamInfoEntity;

@Accessor
public interface DAOAccessor {

	@Query("SELECT * FROM xplan.eventlist")
	Result<ActivityEntity> getActivities();

	@Query("SELECT * FROM xplan.personInformation")
	Result<ColleagueEntity> getColleagues();

	@Query("SELECT * FROM xplan.teaminfo")
	Result<TeamInfoEntity> getTeams();
	
	@Query("SELECT * FROM xplan.groupList")
	Result<GroupEntity> getGroups();
	
	@Query("delete  from xplan.groupList where groupId=?")
	void deleteGroup(UUID id);
	
	@Query("delete from xplan.eventList where eventid=?")
	void deleteActivity(UUID id);
}
