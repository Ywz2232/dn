package com.cy.pj.goods.dao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodsSqlTests {

	@Autowired
	private GoodsDao goodsDao;
	
	@Test
	public void testDeleteById() {
		int rows = goodsDao.deleteById(1);
		System.out.println("delete "+rows+" rows");
	}
	
	@Test
	public void testSelectAll() {
		List<Goods> list = goodsDao.selectAll();
		for(Goods goods:list) {
			System.out.println(goods);
		}
	}
	
	@Test
	public void testInsertById() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		Goods goods = new Goods();
		goods.setId(15);
		goods.setName("java02");
		goods.setRemark("very good");
		goods.setCreatedTime(date);
		int rows = goodsDao.insertById(goods);
		System.out.println("insert "+rows+" rows");
	}
	
	@Test
	public void testUpdateById() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		Goods goods = new Goods();
		goods.setId(12);
		goods.setName("hikariCP");
		goods.setRemark("excellent");
		goods.setCreatedTime(date);
		int rows = goodsDao.updateById(12,goods);
		System.out.println("update "+rows+" rows");
	}
	
	@Test
	public void testDeleteGoods() {
		int rows = goodsDao.deleteGoods(13,14,15);
		System.out.println("delete "+rows+" rows");
	}
}
