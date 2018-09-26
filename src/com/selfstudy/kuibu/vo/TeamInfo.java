package com.selfstudy.kuibu.vo;

import com.selfstudy.kuibu.persistence.TeamInfoEntity;

public class TeamInfo {
	public TeamInfo(String teamID, String name) {
		super();
		this.teamID = teamID;
		this.name = name;
	}

	public TeamInfo(TeamInfoEntity entity) {
		this.teamID = entity.getTeamid().toString();
		this.name = entity.getName();
		this.teamLeader = entity.getTeamLeader();
	}

	private String teamID;

	private String name;
	
	private String teamLeader;

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getTeamID() {
		return teamID;
	}

	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
