package com.selfstudy.kuibu.persistence;

import java.util.Date;
import java.util.UUID;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "xplan", name = "groupList", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class GroupEntity {

	@PartitionKey
	@Column(name = "groupID")
	private UUID id;

	@Column(name = "groupName")
	private String groupName;

	@Column(name="groupColumnName")
	private String groupColumnName;

	@Column(name="groupTableName")
	private String groupTableName;
	
	@Column(name = "groupDesc")
	private String groupDescription;

	@Column(name = "status")
	private int status;
	
	@Column(name = "createTime")
	private Date createTime;

	@Column(name = "updateTime")
	private Date lastUpdateTime;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

	public String getGroupColumnName() {
		return groupColumnName;
	}
	
	public void setGroupColumnName(String groupColumnName) {
		this.groupColumnName = groupColumnName;
	}
	
	public void setGroupTableName(String groupTableName) {
		this.groupTableName = groupTableName;
	}
	
	public String getGroupTableName() {
		return groupTableName;
	}
}
