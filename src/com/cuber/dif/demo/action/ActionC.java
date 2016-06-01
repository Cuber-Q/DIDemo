package com.cuber.dif.demo.action;

import com.cuber.dif.demo.service.ServiceC;
import com.cuber.dif.demo.service.ServiceD;
import com.cuber.dif.framework.basis.annotation.Dependent;
import com.cuber.dif.framework.basis.annotation.Inject;

@Inject
public class ActionC {
	@Dependent
	private ServiceC serviceC;
	
	@Dependent
	private ServiceD serviceD;
}
