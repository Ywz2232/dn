package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTests {

	@Autowired
	@Qualifier("softCache")//
	private Cache cache01;
	
	@Autowired
	@Qualifier("weakCache")
	private Cache cache02;
	
	@Test
	void testCache() {
		System.out.println(cache01);
		System.out.println(cache02);
		System.out.println(cache01==cache02);
	}
}
