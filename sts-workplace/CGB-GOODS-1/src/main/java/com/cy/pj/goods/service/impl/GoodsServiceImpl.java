package com.cy.pj.goods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.goods.dao.Goods;
import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.service.GoodsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public List<Goods> findAll(){
		List<Goods> list = goodsDao.findAll();
		return list;
	}
	
	@Override
	public int deleteById(Integer id) {
		int rows = goodsDao.deleteById(id);
		return rows;
	}
	
	@Override
	public int insert(Goods good) {
		int rows = goodsDao.insert(good);
		return rows;
	}
	
	@Override
	public Goods findById(Integer id) {
		Goods good = goodsDao.findById(id);
		return good;
	}
	
	@Override
	public int updateById(Integer id,String name,String remark) {
		int rows = goodsDao.updateById(id, name, remark);
		return rows;
	}
	
	@Override
	public List<Goods> findByName(String name){
		List<Goods> list = goodsDao.findByName(name);
		return list;
	}
	
	@Override
	public List<Goods> findByRemark(String remark){
		List<Goods> list = goodsDao.findByRemark(remark);
		return list;
	}

}
