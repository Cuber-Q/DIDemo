package com.cuber.dif.demo.action;

import com.cuber.dif.demo.service.ServiceA;
import com.cuber.dif.framework.basis.annotation.Dependent;
import com.cuber.dif.framework.basis.annotation.Inject;

@Inject
public class ActionD {
	@Dependent
	private ServiceA serviceA;
}
