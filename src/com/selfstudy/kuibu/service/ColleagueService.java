package com.selfstudy.kuibu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.Result;
import com.selfstudy.kuibu.persistence.ColleagueEntity;
import com.selfstudy.kuibu.service.api.IColleagueService;
import com.selfstudy.kuibu.vo.Colleague;

public class ColleagueService extends AbstractService implements IColleagueService {

	public List<Colleague> getColleagues() {
		List<Colleague> results = new ArrayList<>();
		Result<ColleagueEntity> colleagues = accessor.getColleagues();
		for (ColleagueEntity colleague : colleagues) {
			results.add(new Colleague(colleague));
		}
		return results;
	}

	public Colleague get(String colleagueId) {
		Colleague result = null;
		Mapper<ColleagueEntity> mapper = manager.mapper(ColleagueEntity.class);
		ColleagueEntity entity = mapper.get(UUID.fromString(colleagueId));
		if (entity != null) {
			result = new Colleague(entity);
		}
		return result;
	}
}
