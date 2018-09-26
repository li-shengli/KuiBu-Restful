package com.selfstudy.kuibu.service;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.mapping.Result;
import com.selfstudy.kuibu.persistence.TeamInfoEntity;
import com.selfstudy.kuibu.service.api.ITeamService;
import com.selfstudy.kuibu.vo.TeamInfo;

public class TeamService extends AbstractService implements ITeamService {

	public List<TeamInfo> getAllTeams() {
		List<TeamInfo> results = new ArrayList<>();
		Result<TeamInfoEntity> teamEntities = accessor.getTeams();
		for (TeamInfoEntity entity : teamEntities) {
			results.add(new TeamInfo(entity));
		}
		return results;
	}

}
