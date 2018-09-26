package com.selfstudy.kuibu.service.api;

import java.util.List;

import com.selfstudy.kuibu.vo.Activity;

public interface IActivitiesService {

	public List<Activity> getActivities();
	
	public Activity getActivity(String activityId);
	
	public Activity getActivity(String activityId, boolean withRegisters);
	
	public void addActivity(Activity activity);
	
	public void deleteActivity(Activity activity);
}
