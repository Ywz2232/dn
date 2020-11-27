package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest//单元测试类需要使用此注解进行描述
public class DefaultCacheTests {
	@Autowired
	private DefaultCache defaultCache;
	
	@Test
	public void testDefaultCache() {
		System.out.println("tDC="+defaultCache);
	}
}
