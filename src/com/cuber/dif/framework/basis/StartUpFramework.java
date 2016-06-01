package com.cuber.dif.framework.basis;

import com.cuber.dif.demo.action.ActionA;

public class StartUpFramework {
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		String packagePath = "com.cuber.dif";
		RegisterHandler.registerFromPackage(packagePath);
		long end = System.currentTimeMillis();
		System.out.println("framework startup in " + (end-start) + "ms.");
		
		ActionA action = (ActionA) GloabelBeanFactory.getBean(ActionA.class);
		action.doSth();
	}
}
