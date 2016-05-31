package com.cuber.dif.framework.basis;

import java.lang.reflect.Field;

import com.cuber.dif.framework.basis.annotation.Dependent;
import com.cuber.dif.framework.basis.annotation.Inject;

public class ReflectUtil {
	public static boolean annotatedWithInject(Class<?> clazz){
		if(null != clazz.getDeclaredAnnotation(Inject.class)){
			return true;
		}
		return false;
	}
	
	public static boolean annotatedWithDependent(Field field){
		if(null != field.getDeclaredAnnotation(Dependent.class)){
			return true;
		}
		return false;
	}
}
