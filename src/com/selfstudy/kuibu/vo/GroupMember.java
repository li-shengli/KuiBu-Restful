package com.selfstudy.kuibu.vo;

public class GroupMember {

	private String personId;

	private String name;

	private String gid;

	private String email;

	public GroupMember() {
	}

	public GroupMember(String personId, String name, String gid, String email) {
		this.personId = personId;
		this.name = name;
		this.gid = gid;
		this.email = email;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
