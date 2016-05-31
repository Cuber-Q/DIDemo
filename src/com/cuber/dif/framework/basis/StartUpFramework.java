package com.cuber.dif.framework.basis;

import com.cuber.dif.demo.Action;

public class StartUpFramework {
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		Class<?> clazz = Action.class;
		RegisterExecutor.register(clazz);
		long end = System.currentTimeMillis();
		System.out.println("framework startup in " + (end-start) + "ms.");
		
		Action action = (Action) GloabelBeanFactory.getBean(Action.class);
		action.doSth();
	}
}
