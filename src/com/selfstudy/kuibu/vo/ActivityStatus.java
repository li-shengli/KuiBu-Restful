package com.selfstudy.kuibu.vo;

public enum ActivityStatus {

	CREATED(0), ON_GOING(1), FINISHED(2);
	
	private int value;
	
	private ActivityStatus(int value){
		this.value = value;
	}
	
	public int value(){
		return this.value;
	}
	
	public static ActivityStatus get(int value){
		for(ActivityStatus status :ActivityStatus.values()){
			if(status.value() == value){
				return status;
			}
		}
		return null;
	}
}
