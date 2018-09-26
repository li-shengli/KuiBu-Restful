package com.selfstudy.kuibu.persistence;

import java.util.UUID;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "xplan", name = "teaminfo", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class TeamInfoEntity {

	@PartitionKey
	@Column(name = "teamid")
	private UUID teamid;

	@Column(name = "name")
	private String name;

	@Column(name = "teamLeader")
	private String teamLeader;

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public TeamInfoEntity() {
	}

	public UUID getTeamid() {
		return teamid;
	}

	public void setTeamid(UUID teamid) {
		this.teamid = teamid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
