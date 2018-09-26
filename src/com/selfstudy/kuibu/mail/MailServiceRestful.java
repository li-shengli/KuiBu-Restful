package com.selfstudy.kuibu.mail;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.selfstudy.kuibu.vo.Activity;

@Path("/")
@Produces({ "text/xml", "application/json" })
public class MailServiceRestful {
	
	private static Logger logger = Logger.getLogger(MailServiceRestful.class);
	
	@EJB
	private IMailAsynServiceLocal mailService;

	@Path("/sendmail")
	@GET
	@Produces("application/json")
	public void getActivities() {
		logger.debug("Trying to send a mail...");
		Activity activty = new Activity();
		activty.setName("Activity for Test");
		activty.setDesc("Check if mail sending succeeded");
		mailService.sendMail("shengli.li@gemalto.com", "www.fortest.com", activty);
	}
	
}
