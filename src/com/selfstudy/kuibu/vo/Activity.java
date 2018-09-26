package com.selfstudy.kuibu.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.selfstudy.kuibu.persistence.ActivityEntity;

public class Activity {

	private String id;

	private String name;

	private String desc;

	private List<Register> registers;

	private ActivityStatus status;
	
	private List<Attribute> attributes;
	
	private int type;

	private long createTime;

	private Date lastUpdateTime;

	public Activity() {
	}

	public Activity(ActivityEntity entity) {
		this.id = entity.getId().toString();
		this.name = entity.getName();
		this.desc = entity.getDesc();
		this.status = ActivityStatus.get(entity.getStatus());
		this.createTime = entity.getCreateTime().getTime();
		this.lastUpdateTime = entity.getLastUpdateTime();
		this.type = entity.getType();
		List<Attribute> attrs = new ArrayList<Attribute>();
		if (entity.getProperties() != null) {
			for (String property : entity.getProperties()) {
				Attribute attr = new Attribute();
				String[] pros = property.split("\\|");
				attr.setName(pros[0]);
				attr.setType(pros[1]);
				attrs.add(attr);
			}
		}
		this.attributes = attrs;
	}

	public ActivityEntity toEntity() {
		ActivityEntity entity = new ActivityEntity();
		entity.setId(UUID.randomUUID());
		entity.setName(getName());
		entity.setColumnName(getColumnName());
		entity.setDesc(getDesc());
		entity.setType(getType());
		if (getStatus() != null) {
			entity.setStatus(getStatus().value());
		} else {
			entity.setStatus(ActivityStatus.CREATED.value());
		}
		
		if(attributes != null) {
			List<String> properties = new ArrayList<String>();
			for (Attribute attribute : attributes) {
				properties.add(attribute.getName() + "|" +attribute.getType());
			}
			entity.setProperties(properties);
		}
		entity.setCreateTime(new Date());
		return entity;
	}

	public Activity(String id, String name, List<Register> registers) {
		this.id = id;
		this.name = name;
		this.registers = registers;
		this.createTime = 0;
		this.status = ActivityStatus.CREATED;
	}

	public void register(Colleague coll) {
		for (Register register : registers) {
			if (register.getColleague().equals(coll)) {
				register.register();
				break;
			}
		}
	}

	public void unregister(Colleague coll) {
		for (Register register : registers) {
			if (register.getColleague().equals(coll.getId())) {
				register.unregister();
				break;
			}
		}
	}

	public void start() {
		this.status = ActivityStatus.ON_GOING;
	}

	public void finish() {
		this.status = ActivityStatus.FINISHED;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColumnName() {
		return "C_"+name.replaceAll(" ", "_");
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Register> getRegisters() {
		return registers;
	}

	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime.getTime();
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public ActivityStatus getStatus() {
		return status;
	}

	public void setStatus(ActivityStatus status) {
		this.status = status;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
