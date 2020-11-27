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
	
	@RequestMapping("/goodsPage")
	public String goodsPage(Model model) {
		List<Goods> list = goodsService.findAll();
		model.addAttribute("goods", list);
		return "goods";
	}
	
	@RequestMapping("/returnToFindAll")
	public String returnFindAll() {
		return "redirect:/goods/goodsPage";
	}
	
	@RequestMapping("/goodsDeleteById/{id}")
	public String goodsDeleteById(@PathVariable Integer id) {
		goodsService.deleteById(id);
		return "redirect:/goods/goodsPage";
	}
	
	@RequestMapping("/goodsInsertPage")
	public String goodsInsertPage() {
		return "addgoods";
	}
	
	@RequestMapping("/goodsInsert")
	public String goodsInsert(Goods good) {
		goodsService.insert(good);
		return "redirect:/goods/goodsPage";
	}
	
	@RequestMapping("/goodsUpdatePage/{id}")
	public String goodsUpdatePage(@PathVariable Integer id,Model model) {
		Goods good = goodsService.findById(id);
		model.addAttribute("good", good);
		return "updategoods";
	}
	
	@RequestMapping("/goodsUpdate")
	public String goodsUpdate(Integer id,String name,String remark) {
		goodsService.updateById(id, name, remark);
		return "redirect:/goods/goodsPage";
	}
	
	@RequestMapping("/findByName")
	public String findByName(String name,Model model) {
		List<Goods> list = goodsService.findByName(name);
		model.addAttribute("goods", list);
		return "goods";
	}
	
	@RequestMapping("/findByRemark")
	public String findByRemark(String remark,Model model) {
		List<Goods> list = goodsService.findByRemark(remark);
		model.addAttribute("goods", list);
		return "goods";
	}
}
