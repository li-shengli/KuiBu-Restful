package com.selfstudy.kuibu.mail;

import java.util.concurrent.Future;

import javax.ejb.Local;

import com.selfstudy.kuibu.vo.Activity;

@Local
public interface IMailAsynServiceLocal {
	public Future<Boolean> sendMail(String mailAddress, String registerURL, Activity activty);
}
