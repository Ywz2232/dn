package com.cy.pj.common.pool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObjectPoolTests {

	
	 @Autowired 
	 private ObjectPool objectPool01;
	  
	 @Autowired 
	 private ObjectPool objectPool02;
	 
	
	@Test
	public void testObjectPool() {
		/*
		 * System.out.println(objectPool01); System.out.println(objectPool02);
		 * System.out.println(objectPool01==objectPool02);
		 */
	}
}
