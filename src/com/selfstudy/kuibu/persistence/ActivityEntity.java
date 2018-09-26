package com.selfstudy.kuibu.persistence;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "xplan", name = "eventlist", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class ActivityEntity {

	@PartitionKey
	@Column(name = "eventid")
	private UUID id;

	@Column(name = "eventtitle")
	private String name;

	@Column(name = "eventdesc")
	private String desc;

	@Column(name = "eventstatus")
	private int status;

	@Column(name = "eventcolumnname")
	private String columnName;
	
	@Column(name = "properties")
	private List<String> properties;

	@Column(name = "createtime")
	private Date createTime;

	@Column(name = "updatetime")
	private Date lastUpdateTime;
	
	@Column(name = "eventtype")
	private int type;

	public ActivityEntity() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
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

	public List<String> getProperties() {
		return properties;
	}

	public void setProperties(List<String> properties) {
		this.properties = properties;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
