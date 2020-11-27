package com.cy;

import java.util.Arrays;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CgbSboot01Application implements CommandLineRunner{
/**
 * 任何一个项目都有一个启动入口,在springboot中的启动类需要有
 * @SpringBootApplication 注解进行描述,并且类中会定义一个main方法
 * main方法在运行时会读取配置文件,并加载指定资源,然后进行初始化操作
 * 1)SpringBoot项目中配置文件的来源:
 * 		SpringBoot官方定义
 * 		第三方定义
 * 		自己定义
 * 2)SpringBoot项目中的资源(类:class文件)加载
 * 		jdk类文件
 * 		Spring类文件
 * 		自己定义的类文件
 * 3)Spring中的项目资源的初始化
 * 		构建实例对象
 * 		基于对象存储数据(配置信息,默认值等)
 * */
	public static void main(String[] args) {
		System.out.println("main.args"+Arrays.toString(args));
		SpringApplication.run(CgbSboot01Application.class, args);
		
	}
	
	@Autowired
	private BeanFactory beanFactory;
	
	@Override
	public void run(String...args)throws Exception {
		System.out.println("main.args---"+Arrays.toString(args));
		System.out.println("bf---"+beanFactory);
		
	}

}
