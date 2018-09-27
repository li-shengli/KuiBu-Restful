package com.selfstudy.kuibu.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;

import com.selfstudy.kuibu.mail.IMailAsynServiceLocal;
import com.selfstudy.kuibu.service.api.IActivityService;
import com.selfstudy.kuibu.service.api.IRegisterService;
import com.selfstudy.kuibu.util.KuiBuConfiguration;
import com.selfstudy.kuibu.vo.*;
import org.apache.log4j.Logger;

import com.selfstudy.kuibu.vo.Activity;
import com.selfstudy.kuibu.vo.ActivityType;
import com.selfstudy.kuibu.vo.Attribute;
import com.selfstudy.kuibu.vo.Colleague;
import com.selfstudy.kuibu.vo.Register;

public class ActivityService extends AbstractService implements IActivityService {

	private static Logger logger = Logger.getLogger(ActivityService.class);

	@Inject
	private IRegisterService registerService;

	@EJB
	private IMailAsynServiceLocal mailService;

	@Override
	public void start(Activity activity) {
		StringBuilder eventValue = new StringBuilder("(");
		StringBuilder eventTypes = new StringBuilder("");
		if (activity.getAttributes() != null) {
			for (Attribute attr : activity.getAttributes()) {
				if (AttributeType.BOOLEAN.getName().equals(attr.getType())) {
					eventValue.append(0);
					eventTypes.append("int");
				} else {
					eventValue.append("''");
					eventTypes.append("text");
				}
				eventValue.append(",");
				eventTypes.append(",");
			}
		}
		eventTypes.append("int,");
		eventValue.append(0).append(",");
		eventTypes.append("text");
		eventValue.append("'");
		eventValue.append(new Date().getTime());
		eventValue.append("'").append("))");

		factory.getSession().execute(
				"alter table xplan.eventparticipate add " + activity.getColumnName() + " tuple<" + eventTypes + ">");
		List<Register> registers = activity.getRegisters();
		for (Register register : registers) {
			String cql = "insert into xplan.eventparticipate (personid, " + activity.getColumnName() + ") values("
					+ register.getColleague().getId() + "," + eventValue + ";";
			if (logger.isDebugEnabled()) {
				logger.debug("execute sql: " + cql);
			}
			factory.getSession().execute(cql);

			if (activity.getType() == ActivityType.Type_Public.getValue()) {
				String registerURL = getReisterURL(register.getColleague().getId(), activity.getId());
				mailService.sendMail(register.getColleague().getMail(), registerURL, activity);
			}
		}
		activity.start();

	}

	private String getReisterURL(String colleageId, String activityId) {
		String host = KuiBuConfiguration.getInstance().get("server.public.host");
		String port = KuiBuConfiguration.getInstance().get("server.public.port");
		String root = KuiBuConfiguration.getInstance().get("server.public.root");
		StringBuilder url = new StringBuilder("http://");
		url.append(host);
		url.append(":");
		url.append(port);
		url.append("/");
		url.append(root);
		url.append("/activity/");
		url.append(activityId);
		url.append("/register/");
		url.append(colleageId);
		return url.toString();
	}

	@Override
	public void finish(Activity activity) {
		activity.finish();
	}

	@Override
	public void register(Activity activity, Colleague colleague, List<Attribute> attributes) {
		registerService.register(activity, colleague, attributes);
	}

	@Override
	public void unregister(Activity activity, Colleague colleague) {
		registerService.unregister(activity, colleague);
	}

}
