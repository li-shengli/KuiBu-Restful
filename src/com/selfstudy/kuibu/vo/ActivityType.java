package com.selfstudy.kuibu.vo;

public enum ActivityType {
	Type_Private(0),
	Type_Public(1);
	
	private int value;
	
	private ActivityType (int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
