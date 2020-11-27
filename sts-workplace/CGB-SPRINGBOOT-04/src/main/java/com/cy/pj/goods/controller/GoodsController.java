package com.cy.pj.goods.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.cy.pj.goods.dao.Goods;
import com.cy.pj.goods.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/doGoodsPage")
	public String doGoodsPage(Model model) {
		List<Goods> list = goodsService.findAll();  
		model.addAttribute("goods", list);
		return "goods";//viewname
		//完整路径:prefix+viewname+suffix
		//ViewResolver(ThymleafViewResolver)负责解析viewname
		}
	
	/**
	 * @param id 商品id,一定要与客户端传过来的参数id名相同
	 * @return 重定向刀doGoodsPage
	 * rest风格:一种软件架构编码风格,其设计的目的主要是在异构系统之间实现兼容(跨平台)
	 * rest风格的url定义:{a}/{b}/{c}
	 * 若希望方法参数的值来自rest风格的url,
	 * 可以使用@PathVariable注解对方法参数进行描述(方法参数名需要和url中{ }内部变量名相同)*/
	@RequestMapping("/doDeleteById/{id}")
	public String doDeleteById(@PathVariable Integer id) {
		goodsService.deleteById(id);
		//return "forward:doGoodsPage";
		return "redirect:/goods/doGoodsPage";
	}
	
	@RequestMapping("doaddgoods")
	public String addgoodspages() {
		return "addgoods";
	}
	
	@RequestMapping("/doSaveGoods")
	public String doSaveGoods(Goods goods) {
		goodsService.addGoods(goods);
		return "redirect:/goods/doGoodsPage";
	}
	
	@RequestMapping("/doupdateById/{id}")
	public String updategoods(@PathVariable Integer id,Model model) {
		Goods goods = goodsService.findById(id);
		model.addAttribute("good", goods);
		return "updategoods";
	}
	
	@RequestMapping("/doUpdateGoods")
	public String doUpdateGoods(Integer id,String name,String remark) {
		goodsService.updateById2(id,name,remark);
		return "redirect:/goods/doGoodsPage";
	}
}
