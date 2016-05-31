package com.cuber.dif.demo;

import com.cuber.dif.framework.basis.annotation.Dependent;
import com.cuber.dif.framework.basis.annotation.Inject;

@Inject
public class Action {
	@Dependent
	private Service service;
	
	public void doSth(){
		System.out.println("[Action] Now I will do something.");
		service.doSthElse();
	}
	
	@Override
	public String toString(){
		return "OK, Action is prepareing!";
	}
}
