package com.selfstudy.kuibu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.Result;
import com.selfstudy.kuibu.persistence.ActivityEntity;
import com.selfstudy.kuibu.service.api.IActivitiesService;
import com.selfstudy.kuibu.vo.Activity;

public class ActivitiesService extends AbstractService implements IActivitiesService {

	@Inject
	private RegisterService registerService;

	@Inject
	private ActivityService activityService;

	@Override
	public Activity getActivity(String activityId) {
		return getActivity(activityId, true);
	}

	public Activity getActivity(String activityId, boolean withRegisters) {
		Activity result = null;
		Mapper<ActivityEntity> mapper = manager.mapper(ActivityEntity.class);
		ActivityEntity entity = mapper.get(UUID.fromString(activityId));
		if (entity == null) {
			return null;
		}
		result = new Activity(entity);

		if (withRegisters) {
			result.setRegisters(registerService.getRegisters(result));
		}
		return result;
	}

	@Override
	public List<Activity> getActivities() {
		List<Activity> results = new ArrayList<>();
		Result<ActivityEntity> activities = accessor.getActivities();
		for (ActivityEntity activity : activities) {
			results.add(new Activity(activity));
		}
		return results;
	}

	@Override
	public void addActivity(Activity activity) {
		Mapper<ActivityEntity> activityMapper = manager.mapper(ActivityEntity.class);
		ActivityEntity entity = activity.toEntity();
		activityMapper.save(entity);

		Activity newActivity =new Activity(entity);
		newActivity.setRegisters(activity.getRegisters());
		activityService.start(newActivity);
	}

	@Override
	public void deleteActivity(Activity activity) {

		// delete record from activity
		accessor.deleteActivity(UUID.fromString(activity.getId()));

		// remove column
		factory.getSession().execute("alter table xplan.eventparticipate drop " + activity.getColumnName());
	}

}
