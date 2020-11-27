package com.cy.pj.goods.service;

import java.util.List;

import com.cy.pj.goods.dao.Goods;

public interface GoodsService {

	public List<Goods> findAll();
	
	public int deleteById(Integer id);
	
	public int insert(Goods good);
	
	public Goods findById(Integer id);
	
	public int updateById(Integer id,String name,String remark);
	
	public List<Goods> findByName(String name);
	
	public List<Goods> findByRemark(String remark);
}
