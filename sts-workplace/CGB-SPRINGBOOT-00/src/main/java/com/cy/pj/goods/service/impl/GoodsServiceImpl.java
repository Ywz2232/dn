package com.cy.pj.goods.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.goods.Goods;
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
		return goodsDao.findAll();
	}
}
