package com.cy.pj.goods.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.goods.Goods;

@SpringBootTest
public class GoodsServiceTests {
	@Autowired
	private GoodsService goodsService;
	@Test
	public void deleteById() {
		int rows = goodsService.deleteById(15);
		System.out.println("delete "+rows+" rows");
	}
	@Test
	public void findAll() {
		List<Goods> list = goodsService.findAll();
		for(Goods goods:list) {
			System.out.println(goods);
		}
	}
}
