package com.cuber.dif.framework.basis;

import java.util.HashMap;
import java.util.Set;

public class GloabelBeanFactory {
	private static HashMap<String,Object> beanFactory;
	
	static{
		System.out.println("GlobelBeanFactory has been created...");
		beanFactory = new HashMap<String,Object>();
	}
	
	
	
	public static void addBean(Object obj){
		beanFactory.put(getClassName(obj), obj);
	}
	
	protected static String getClassName(Object obj){
		return obj.getClass().getName();
	}
	
	public static Object getBean(Class<?> clazz) {
		// TODO Auto-generated method stub
		return getBean(clazz.getName());
	}
	
	public static Object getBean(String className){
		return beanFactory.get(className);
	}
	
	public static void showBeans(){
		Set<String> keySet = beanFactory.keySet();
		for(String key : keySet){
			Object obj = GloabelBeanFactory.getBean(key);
			System.out.println(obj.toString());
		}
	}

}
