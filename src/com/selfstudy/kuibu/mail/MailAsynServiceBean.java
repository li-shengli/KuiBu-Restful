package com.selfstudy.kuibu.mail;

import java.util.Properties;
import java.util.concurrent.Future;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.selfstudy.kuibu.util.XplanConfiguration;
import org.apache.log4j.Logger;

import com.selfstudy.kuibu.vo.Activity;

@Stateless
@LocalBean
public class MailAsynServiceBean implements IMailAsynServiceLocal {
	
	private static Logger logger = Logger.getLogger(MailAsynServiceBean.class);

	@Override
	@Asynchronous 
	public Future<Boolean> sendMail(String mailAddress, String registerURL, Activity activty) {
		sendMail(mailAddress, activty.getName(), activty.getDesc(), registerURL);
		return null;
	}

	public void sendMail(String mailAddress, String activtyName, String activityDesc, String registerURL) {    
	      // Recipient's email ID needs to be mentioned.
	      String to = mailAddress;

	      // Sender's email ID needs to be mentioned
	      String from = XplanConfiguration.getInstance().get("mail.from");

	      // Assuming you are sending email from localhost
	      String host = XplanConfiguration.getInstance().get("mail.host");
	      String port = XplanConfiguration.getInstance().get("mail.port");
	      String auth = XplanConfiguration.getInstance().get("mail.auth");
	      String debug = XplanConfiguration.getInstance().get("mail.debug");
	      String sslEnable = XplanConfiguration.getInstance().get("mail.ssl.enable");
	      String login = XplanConfiguration.getInstance().get("mail.user.login");
	      String password = XplanConfiguration.getInstance().get("mail.user.password");
	      String starttls = XplanConfiguration.getInstance().get("mail.starttls.enable");

	      // Get system properties
	      Properties properties = new Properties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);
	      properties.put("mail.smtp.port", port);
	      properties.put("mail.smtp.auth", auth);
	      properties.put("mail.debug", debug);
	      properties.put("mail.smtp.ssl.enable", sslEnable);
	      properties.put("mail.smtp.starttls.enable", starttls);  
	      properties.put("mail.smtp.user", login);
	      
	      System.setProperty("user.name", "shengli");
	      System.setProperty("java.net.preferIPv4Stack" , "true");

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
	    	  protected PasswordAuthentication getPasswordAuthentication() {
	    		  return new PasswordAuthentication(login, password);
	    	  }
	      	});

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("Activity Register: " + activtyName);

	         // Now set the actual message
	         StringBuilder mailContent = new StringBuilder();
	         if (activityDesc != null) {
	        	 mailContent.append(activityDesc);
	        	 mailContent.append("\n");
	         }
	         mailContent.append("Please register from: ");
	         mailContent.append(registerURL);
	         message.setText(mailContent.toString());

	         // Send message
	         Transport.send(message);
	         logger.info("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
}
