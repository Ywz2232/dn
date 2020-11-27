package com.cy.pj.common.pool;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/**
 * 将此类交给spring管理,spring何时创建此对象
 * 	启动类运行时,加载改类,创建对象
 * 一个对象创建以后,存储到内容,长时间不用会有什么影响
 *	占用内存---延迟加载,也叫懒加载,注解Lazy 
 *spring中的bean对象的延迟加载特性
 *	按需加载
 *什么场景下对象适合延迟加载
 *	大对象,用的少*/
@Component
@Lazy//用于告诉spring框架,他描述的类的对象实例,假如暂时不需要使用,就先不创建--------延迟加载,@Lazy(true),@Lazy(value=true),一般针对单例对象
//@Lazy(false)-----类加载就创建,可以不写,默认值为true
@Scope("prototype")//默认为singleton,单例;prototype,多例
public class ObjectPool {
	public ObjectPool() {
		System.out.println("ObjectPool.ObjectPool()...");
	}
	
	@PostConstruct//描述的方法会在对象构建后执行,用于执行初始化操作
	public void init() {
		System.out.println("ObjectPool.init()...");
	} 
	
	@PreDestroy//描述的方法会在单例对象销毁之前执行,spring容器在销毁之前会先将容器(bean池)中的对象进行移除
			   //在移除对象时,假如对象中定义了生命周期销毁方法,会调用销毁方法
	public void close() {
		System.out.println("ObjectPool.close()...");
	}
}
