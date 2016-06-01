package com.cuber.dif.framework.basis;

import java.lang.reflect.Field;
import java.util.List;

public class RegisterExecutor {
	public static void register(Class<?> clazz){
		try {
			if(null == clazz){
				throw new Exception("class is null");
			}
			if(!ReflectUtil.annotatedWithInject(clazz)){
				return;
			}
			if(null != GloabelBeanFactory.getBean(clazz)){
				return;
			}
			GloabelBeanFactory.addBean(clazz.newInstance());
			System.out.println("register [" + clazz.getName() + "] done");
			registerDependentBean(clazz);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void register(List<String> clazzNames){
		for(String name : clazzNames){
			try {
				register(Class.forName(name));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("class not found, " + name);
			}
		}
	}
	
	public static void registerDependentBean(Class<?> clazz) 
			throws IllegalArgumentException, IllegalAccessException{
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			if(ReflectUtil.annotatedWithDependent(field)){
				Class<?> dependentBean = field.getType();
				register(dependentBean);
				field.setAccessible(true);
				field.set(GloabelBeanFactory.getBean(clazz), 
						GloabelBeanFactory.getBean(dependentBean));
			}
		}
	}
}
