package com.cy.pj.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Component描述类时,用于告诉spring框架,由spring构建此类对象
 * 1)Spring框架通过反射为我们的类型构建对象
 * 2)反射构建对象需要用到的API:Class,Constructor*/

@Component
public class SearchService {
	//@Autowired
	//@Qualifier("softCache")
	private Cache cache;
	
	
	//public void setCache(@Qualifier("softCache")Cache cache) { this.cache=cache;}
	  
	public SearchService(Cache cache) { 
		this.cache=cache; 
	}
	 
	public Cache getCache() {
		return this.cache;
	}
}
