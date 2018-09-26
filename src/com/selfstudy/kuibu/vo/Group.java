package com.selfstudy.kuibu.vo;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.selfstudy.kuibu.persistence.GroupEntity;

public class Group {

	private String id;

	private String groupName;

	private String groupDescription;

	private Date createTime;

	private Date lastUpdateTime;

	public List<GroupMember> members;

	public Group(){}
	
	public Group(GroupEntity entity) {
		this.id = entity.getId().toString();
		this.groupName = entity.getGroupName();
		this.groupDescription = entity.getGroupDescription();
		this.createTime = entity.getCreateTime();
		this.lastUpdateTime = entity.getLastUpdateTime();
	}

	public GroupEntity toEntity() {
		GroupEntity entity = new GroupEntity();
		entity.setId(UUID.randomUUID());
		entity.setGroupName(this.groupName);
		entity.setGroupColumnName(getGroupColumnName());
		entity.setGroupTableName(getGroupTableName());
		entity.setGroupDescription(this.groupDescription);
		entity.setCreateTime(new Date());
		return entity;
	}

	public String getGroupTableName() {
		return "group_" + groupName.replace(" ", "_");
	}

	public String getGroupColumnName() {
		return "C_" + groupName.replaceAll(" ", "_");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public List<GroupMember> getMembers() {
		return members;
	}

	public void setMembers(List<GroupMember> members) {
		this.members = members;
	}
}
