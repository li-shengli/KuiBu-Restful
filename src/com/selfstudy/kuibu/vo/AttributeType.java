package com.selfstudy.kuibu.vo;

public enum AttributeType {
	BOOLEAN(0, "boolean"), STRING (1, "string");
	
	private int value;
	
	private String name;
	
	private AttributeType (int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
}
