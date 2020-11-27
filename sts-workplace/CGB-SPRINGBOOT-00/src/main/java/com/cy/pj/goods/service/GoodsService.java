package com.cy.pj.goods.service;

import java.util.List;

import com.cy.pj.goods.Goods;

/**
 * 业务层接口
 * 1)核心业务
 * 2)扩展业务
 * */

public interface GoodsService {
	
	public int deleteById(Integer id);
	
	public List<Goods> findAll();


}
