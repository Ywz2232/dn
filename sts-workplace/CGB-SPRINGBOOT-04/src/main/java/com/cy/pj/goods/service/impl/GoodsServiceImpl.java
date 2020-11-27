package com.cy.pj.goods.service.impl;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.goods.dao.Goods;
import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	private Logger log = LoggerFactory.getLogger(GoodsServiceImpl.class);
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public int deleteById(Integer id) {
		long t1 = System.currentTimeMillis();
		int rows = goodsDao.deleteById(id);
		long t2 = System.currentTimeMillis();
		log.info("dBI time :{}", (t2-t1));
		return rows;
	}
	
	@Override
	public List<Goods> findAll(){
		return goodsDao.selectAll();
	}
	
	@Override
	public int addGoods(Goods goods) {
		Date date = new Date(System.currentTimeMillis());
		goods.setCreatedTime(date);
		return goodsDao.insertById(goods);
	}
	
	@Override
	public Goods findById(Integer id) {
		Goods goods = goodsDao.findById(id);
		return goods;
	}
	
	@Override
	public int updateById(Integer id,Goods goods) {
		Date date = new Date(System.currentTimeMillis());
		goods.setCreatedTime(date);
		int rows = goodsDao.updateById(id,goods);
		return rows;
	};
	
	@Override
	public int updateById2(Integer id,String name,String remark) {
		Date createdTime = new Date();
		int rows = goodsDao.updateById2(id, name, remark,createdTime);
		return rows;
	}
}