package com.selfstudy.kuibu.vo;

import java.util.UUID;

import com.selfstudy.kuibu.persistence.ColleagueEntity;

public class Colleague {

	private String id;

	private String name;

	private char gender; 

	private String szm;

	private String team;
	
	private String mail;
	
	private String gid;

	public Colleague() {
	}

	public Colleague(UUID id, String name, Gender gender, String szm, String team) {
		this.id = id.toString();
		this.name = name;
		this.gender = gender.getGender();
		this.szm = szm;
		this.team = team;
	}

	public Colleague(ColleagueEntity entity){
		this.id = entity.getId().toString();
		this.name=entity.getName();
		this.gender = Gender.get(entity.getGender()).getGender();
		this.szm = entity.getSzm();
		this.team = entity.getTeam();
		this.mail = entity.getMail();
		this.gid = entity.getGid();
	}
	
	public ColleagueEntity toEntity(){
		ColleagueEntity entity = new ColleagueEntity();
		entity.setId(UUID.randomUUID());
		entity.setName(this.getName());
		entity.setGender(Gender.getIntValue(gender));
		entity.setSzm(this.getSzm());
		entity.setTeam(this.getTeam());
		return entity;
	}
	 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender.getGender();
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

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Colleague) {
			Colleague coll = (Colleague) arg0;
			if (this.id.toString().equals(coll.getId())) {
				return true;
			}
		}
		return false;
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

	public void setGender(char gender) {
		this.gender = gender;
	}
}
