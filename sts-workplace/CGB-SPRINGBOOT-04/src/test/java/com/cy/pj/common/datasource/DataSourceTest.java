package com.cy.pj.common.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataSourceTest {

	/**
	 * dataSource对象在运行时指向的具体对象 : com.zaxxer.hikari.HikariDataSource
	 * dataSource对象是由谁创建的?Spring框架(基于底层的自动配置-datasource auto configuration)*/
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testGetConnection() throws SQLException {
		//System.out.println(dataSource.getClass().getName());//com.zaxxer.hikari.HikariDataSource
		//获取连接的过程
		//第一次获取连接时,首先会检测连接池是否存在,若不存在则创建并初始化池
		//底层基于Driver对象创建与数据库的连接并将连接放入池中
		//从池中返回用户需要的连接
		
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
}
