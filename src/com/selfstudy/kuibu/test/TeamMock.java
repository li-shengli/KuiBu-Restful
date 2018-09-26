package com.selfstudy.kuibu.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.selfstudy.kuibu.vo.TeamInfo;

public class TeamMock {
	private final static Map<String, TeamInfo> teams = new HashMap<String, TeamInfo>();
	
	static {
		teams.put("OSM", new TeamInfo("11", "OSM"));
		teams.put("DMC", new TeamInfo("12", "DMC"));
		teams.put("Roaming", new TeamInfo("13", "ROAMING"));
		teams.put("TP", new TeamInfo("14", "DBA"));
		teams.put("OSL", new TeamInfo("15", "TAM"));
		teams.put("OSL", new TeamInfo("15", "IW"));
	}
	
	public static List<TeamInfo> getAllTeams() {
		List<TeamInfo> teamInfos = new ArrayList<TeamInfo>();
		teamInfos.addAll(teams.values());
		return teamInfos;
	}
}
