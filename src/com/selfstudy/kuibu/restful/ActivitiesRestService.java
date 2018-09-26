package com.selfstudy.kuibu.restful;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.selfstudy.kuibu.service.api.IActivitiesService;
import com.selfstudy.kuibu.vo.Activity;
import com.selfstudy.kuibu.vo.Result;

@Path("/")
@Produces({ "text/xml", "application/json" })
public class ActivitiesRestService {

	@Inject
	private IActivitiesService activitiesService;

	@Path("/activities")
	@GET
	@Produces("application/json")
	public Result<Activity> getActivities() {
		Result<Activity> result = new Result<Activity>();
		result.setData(activitiesService.getActivities());
		return result;
	}

	@Path("/activity/{activityId}")
	@GET
	@Produces("application/json")
	public Activity getActivity(@PathParam("activityId") String activityId) {
		return activitiesService.getActivity(activityId);
	}

	@Path("/activity/create")
	@POST
	@Produces("application/json")
	public void createActivity(Activity activity) {
		activitiesService.addActivity(activity);
	}

	@Path("/activity/{activityId}")
	@DELETE
	@Produces("application/json")
	public void deleteActivity(@PathParam("activityId") String activityId) {
		Activity activity = activitiesService.getActivity(activityId);
		activitiesService.deleteActivity(activity);
	}
}
