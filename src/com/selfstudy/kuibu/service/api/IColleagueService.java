package com.selfstudy.kuibu.service.api;

import java.util.List;

import com.selfstudy.kuibu.vo.Colleague;

public interface IColleagueService {

	public List<Colleague> getColleagues();

	public Colleague get(String colleagueId);

}
