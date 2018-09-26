package com.selfstudy.kuibu.persistence;

import java.util.Date;
import java.util.UUID;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.selfstudy.kuibu.vo.Gender;

@Table(keyspace = "xplan", name = "personInformation", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class ColleagueEntity {
	
	@PartitionKey
	@Column(name = "personid")
	private UUID id;

	@Column(name="name")
	private String name;

	@Column(name="gender")
	private int gender;

	@Column(name="namefirstletter")
	private String szm;

	@Column(name="team")
	private String team;

	@Column(name="createtime")
	private Date createTime;
	
	@Column(name="updatetime")
	private Date updateTime;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="GID")
	private String gid;
	
	public ColleagueEntity() {
	}

	public ColleagueEntity(UUID id, String name, Gender gender, String szm, String team) {
		this.id = id;
		this.name = name;
		this.gender = gender.value();
		this.szm = szm;
		this.team = team;
		this.createTime = new Date();
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getSzm() {
		return szm;
	}

	public void setSzm(String szm) {
		this.szm = szm;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}
	
	
}
