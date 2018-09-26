package com.selfstudy.kuibu.restful;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.selfstudy.kuibu.service.api.IGroupService;
import com.selfstudy.kuibu.vo.Group;
import com.selfstudy.kuibu.vo.Result;

@Path("/")
@Produces({ "text/xml", "application/json" })
public class GroupRestService {

	@Inject
	private IGroupService groupService;

	@Path("/groups")
	@GET
	@Produces("application/json")
	public Result<Group> getGroups() {
		Result<Group> results = new Result<Group>();
		results.setData(groupService.getGroups());
		return results;
	}

	@Path("/group/update")
	@PUT
	@Produces("application/json")
	public void updpateGroup( Group group) {
		groupService.updateGroup(group);
	}

	@Path("/group/{groupId}")
	@DELETE
	@Produces("application/json")
	public void deleteGroup(@PathParam("groupId") String groupId) {
		Group group = groupService.getGroup(groupId);
		groupService.deleteGroup(group);
	}

	@Path("/group/create")
	@POST
	@Produces("application/json")
	public void createGroup(Group group) {
		groupService.createGroup(group);
	}
}
