package com.selfstudy.kuibu.restful;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.selfstudy.kuibu.service.api.IActivitiesService;
import com.selfstudy.kuibu.service.api.IActivityService;
import com.selfstudy.kuibu.service.api.IColleagueService;
import com.selfstudy.kuibu.vo.Activity;
import com.selfstudy.kuibu.vo.Attribute;
import com.selfstudy.kuibu.vo.Colleague;

@Path("/")
@Produces({ "text/xml", "application/json" })
public class ActivityRestService {

	@Inject
	private IActivitiesService activitiesService;

	@Inject
	private IActivityService activityService;

	@Inject
	private IColleagueService colleagueService;

	@Path("/activity/{activityId}/register/{colleagueId}")
	@POST
	@Produces("application/json")
	public void register(@PathParam("activityId") String activityId, @PathParam("colleagueId") String colleagueId, List<Attribute> attributes) {
		Activity activity = activitiesService.getActivity(activityId);
		Colleague colleague = colleagueService.get(colleagueId);
		activityService.register(activity, colleague, attributes);
	}

	@Path("/activity/{activityId}/unregister/{colleagueId}")
	@GET
	@Produces("application/json")
	public void unregister(@PathParam("activityId") String activityId, @PathParam("colleagueId") String colleagueId) {
		Activity activity = activitiesService.getActivity(activityId);
		Colleague colleague = colleagueService.get(colleagueId);
		activityService.unregister(activity, colleague);
	}
	
	@Path("/activity/{activityId}/members")
	@GET
	@Produces("application/json")
	public Activity getRegisters(@PathParam("activityId") String activityId) {
		Activity activity = activitiesService.getActivity(activityId, true);
		return activity;
	}
}
