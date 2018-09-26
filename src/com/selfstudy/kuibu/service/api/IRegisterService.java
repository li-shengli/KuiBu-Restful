package com.selfstudy.kuibu.service.api;

import java.util.List;

import com.selfstudy.kuibu.vo.Activity;
import com.selfstudy.kuibu.vo.Attribute;
import com.selfstudy.kuibu.vo.Colleague;
import com.selfstudy.kuibu.vo.Register;

public interface IRegisterService {

	public List<Register> getRegisters(Activity activity);

	public void register(Activity activity, Colleague colleague, List<Attribute> attributes);

	public void unregister(Activity activity, Colleague colleague);
}
