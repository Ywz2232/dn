package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchServiceTests {

	@Autowired
	private SearchService searchService;
	
	@Test
	public void testSS() {
		Cache cache00 = searchService.getCache();
		System.out.println(cache00);
	}
}
