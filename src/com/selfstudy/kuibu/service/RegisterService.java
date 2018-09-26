package com.selfstudy.kuibu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.TupleValue;
import com.selfstudy.kuibu.service.api.IRegisterService;
import com.selfstudy.kuibu.vo.Activity;
import com.selfstudy.kuibu.vo.Attribute;
import com.selfstudy.kuibu.vo.AttributeType;
import com.selfstudy.kuibu.vo.Colleague;
import com.selfstudy.kuibu.vo.Register;

public class RegisterService extends AbstractService implements IRegisterService {
	
	private static Logger logger = Logger.getLogger(RegisterService.class);

	@Inject
	private ColleagueService colleagueService;

	public List<Register> getRegisters(Activity activity) {
		List<Register> results = new ArrayList<>();

		List<Colleague> colleagues = colleagueService.getColleagues();
		Map<String, Colleague> colleagueMap = new HashMap<>();
		for (Colleague colleague : colleagues) {
			colleagueMap.put(colleague.getId(), colleague);
		}

		String eventColumnName = activity.getColumnName();
		ResultSet resultSet = manager.getSession()
				.execute("SELECT personid," + eventColumnName + " FROM xplan.eventparticipate");
		for (Row row : resultSet.all()) {
			UUID personId = row.get(0, UUID.class);
			TupleValue event = row.get(1, TupleValue.class);
			
			int index = activity.getAttributes().size();
			int registered = event.getInt(index);
			String dataTimeStr = event.getString(index+1);
			long registerTime = 0;
			if (dataTimeStr != null) {
				registerTime = Long.valueOf(dataTimeStr);
			}

			results.add(new Register(colleagueMap.get(personId.toString()), (registered == 1 ? true : false), registerTime));
		}
		return results;
	}

	public void register(Activity activity, Colleague colleague, List<Attribute> attributes) {
		String eventColumnName = activity.getColumnName();

		String columnValue = caculateEventValue(activity.getAttributes(), attributes);
		String cql = "update xplan.eventparticipate set " + eventColumnName
				+ " = "+columnValue+" where personid=" + colleague.getId().toString() + ";";
		
		if (logger.isDebugEnabled()) {
			logger.debug("Register activity by using cql ["+cql+"]");
		}
		manager.getSession().execute(cql);
	}
	
	private String caculateEventValue(List<Attribute> labels, List<Attribute> values) {
		Map<String, String> valueMap = new HashMap<String, String>();
		for (Attribute attr : values) {
			valueMap.put(attr.getName(), attr.getValue());
		}
		
		StringBuilder eventValue = new StringBuilder("(");
		for (Attribute tmplt : labels) {
			if (AttributeType.STRING.getName().equals(tmplt.getType())) {
				eventValue.append("'");
				eventValue.append(valueMap.get(tmplt.getName()));
				eventValue.append("',");
			}
			if (AttributeType.BOOLEAN.getName().equals(tmplt.getType())) {
				if (Boolean.valueOf(valueMap.get(tmplt.getName()))) {
					eventValue.append(1);
				} else {
					eventValue.append(0);
				}
				eventValue.append(",");
			}
		}
		eventValue.append("1,");
		eventValue.append("'");
		eventValue.append(new Date().getTime());
		eventValue.append("'");
		eventValue.append(")");
		
		return eventValue.toString();
	}

	public void unregister(Activity activity, Colleague colleague) {
		String eventColumnName = activity.getColumnName();
		
		String columnValue = caculateUnregisterEventValue(activity.getAttributes());
		String cql = "update xplan.eventparticipate set " + eventColumnName
				+ " = "+columnValue+" where personid=" + colleague.getId().toString() + ";";
		
		if (logger.isDebugEnabled()) {
			logger.debug("Unregister activity by using cql ["+cql+"]");
		}
		manager.getSession().execute(cql);
	}
	
	private String caculateUnregisterEventValue(List<Attribute> labels) {
		
		StringBuilder eventValue = new StringBuilder("(");
		for (Attribute tmplt : labels) {
			if (AttributeType.STRING.getName().equals(tmplt.getType())) {
				eventValue.append("'',");
			}
			if (AttributeType.BOOLEAN.getName().equals(tmplt.getType())) {
				eventValue.append(0);
				eventValue.append(",");
			}
		}
		eventValue.append("0,");
		eventValue.append("'");
		eventValue.append(new Date().getTime());
		eventValue.append("'");
		eventValue.append(")");
		
		return eventValue.toString();
	}
}
