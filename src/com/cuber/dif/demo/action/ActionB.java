package com.cuber.dif.demo.action;

import com.cuber.dif.demo.service.ServiceB;
import com.cuber.dif.framework.basis.annotation.Dependent;
import com.cuber.dif.framework.basis.annotation.Inject;

@Inject
public class ActionB {
	@Dependent
	private ServiceB serviceB;
}
