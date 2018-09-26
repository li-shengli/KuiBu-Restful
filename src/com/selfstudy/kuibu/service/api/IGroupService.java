package com.selfstudy.kuibu.service.api;

import java.util.List;

import com.selfstudy.kuibu.vo.Group;

public interface IGroupService {

	public void createGroup(Group group);

	public List<Group> getGroups();

	public Group getGroup(String id);
	
	public void updateGroup(Group group);

	public void deleteGroup(Group group);
}
