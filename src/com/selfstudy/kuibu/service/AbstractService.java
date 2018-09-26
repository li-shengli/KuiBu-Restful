package com.selfstudy.kuibu.service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.datastax.driver.mapping.MappingManager;
import com.selfstudy.kuibu.persistence.factory.DAOAccessor;
import com.selfstudy.kuibu.persistence.factory.DAOFactory;

public abstract class AbstractService {
	
	@Inject
	DAOFactory factory;

	MappingManager manager;
	
	DAOAccessor accessor;

	@PostConstruct
	public void initialize() {
		manager = new MappingManager(factory.getSession());
		accessor =  manager.createAccessor(DAOAccessor.class);
	}
	
}
