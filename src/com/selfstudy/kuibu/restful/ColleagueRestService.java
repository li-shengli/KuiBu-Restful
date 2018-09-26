package com.selfstudy.kuibu.restful;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.selfstudy.kuibu.service.api.IColleagueService;
import com.selfstudy.kuibu.vo.Colleague;
import com.selfstudy.kuibu.vo.Result;

@Path("/")
@Produces({ "text/xml", "application/json" })
public class ColleagueRestService {
	
	@Inject
	private IColleagueService colleagueService;
	
	@Path("/colleagues")
	@GET
	@Produces("application/json")
	public Result<Colleague> getColleagues(){
		Result<Colleague> result = new Result<Colleague>();
		result.setData(colleagueService.getColleagues());
		return result;
	}
	
	@Path("/colleague/{colleageId}")
	@GET
	@Produces("application/json")
	public Colleague getColleague(@PathParam("colleageId") String id){
		return colleagueService.get(id);
	}
}
