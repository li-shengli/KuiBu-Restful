package com.selfstudy.kuibu.restful;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.selfstudy.kuibu.service.api.ITeamService;
import com.selfstudy.kuibu.vo.Result;
import com.selfstudy.kuibu.vo.TeamInfo;

@Path("/")
@Produces({ "text/xml", "application/json" })
public class TeamRestService {
	private static Logger logger = Logger.getLogger(TeamRestService.class);
	
	@Inject
	private ITeamService teamService;

	@Path("/teams")
	@GET
	@Produces("application/json")
	public Result<TeamInfo> getAllTeams() {
		if(logger.isDebugEnabled()) {
			logger.debug("Begin to load all team informaiton...");
		}
		Result<TeamInfo> result = new Result<TeamInfo>();
		result.setData(teamService.getAllTeams());
		return result;
	}
}
