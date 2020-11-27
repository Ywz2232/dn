package com.cy.java.api.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.util.Arrays;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Mapper{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Select{ String value();}

@Mapper
interface GoodsDao{
	@Select("select * from tb_goods")
	Object findGoods();
}

public class TestAnnotation01 {
	public static void main(String[] args) throws Exception {
		System.out.println(t1());
		t2();		
	}
	
	public static boolean t1() throws ClassNotFoundException {
		return Class.forName("com.cy.java.api.annotation.GoodsDao").isAnnotationPresent(Mapper.class);
	}
	
	public static void t2() throws Exception {
		Class<?> clazz = Class.forName("com.cy.java.api.annotation.GoodsDao");
		Method method = clazz.getMethod("findGoods",null);
		Select annotation = method.getAnnotation(Select.class);
		System.out.println(annotation.value());
	}
	
}
