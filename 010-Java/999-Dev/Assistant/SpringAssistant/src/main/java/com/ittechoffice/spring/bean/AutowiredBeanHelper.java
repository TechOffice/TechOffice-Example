package com.ittechoffice.spring.bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;

public class AutowiredBeanHelper {
	
	public static boolean hasAutowired(Annotation[] annotations ){
		for (int i=0; i<annotations.length; i++){
			Annotation annotation = annotations[i];
			if (annotation.annotationType().equals(Autowired.class)){
				return true;
			}
		}
		return false;
	}
	
	public static void listAutowiredField(Class clz){
		Field[] fields = clz.getDeclaredFields();
		for (int i=0; i<fields.length; i++){
			Field field = fields[i];
			Annotation[] annotations = field.getAnnotations();
			if (hasAutowired(annotations)){
				System.out.println(field.getType().getName());
			}
		}
	}
}
