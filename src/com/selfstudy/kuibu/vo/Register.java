package com.selfstudy.kuibu.vo;

import java.util.Date;

public class Register {

	private Colleague colleague;

	private boolean registered;

	private long registerTime;

	public Register() {
	}

	public Register(Colleague colleague) {
		this(colleague, false, 0);
	}

	public Register(Colleague colleague, boolean registered, long registerTime) {
		this.colleague = colleague;
		this.registered = registered;
		this.registerTime = registerTime;
	}

	public void register() {
		this.registered = true;
		this.registerTime = new Date().getTime();
	}

	public void unregister() {
		this.registered = false;
		this.registerTime = 0;
	}

	public Colleague getColleague() {
		return colleague;
	}

	public void setColleague(Colleague colleague) {
		this.colleague = colleague;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public long getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(long registerTime) {
		this.registerTime = registerTime;
	}

}
