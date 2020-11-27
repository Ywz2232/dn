package com.cy.pj.goods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.goods.Goods;

@Mapper
public interface GoodsDao {
	
	@Delete("delete from tb_goods where id=#{id}")
	public int deleteById(Integer id);
	
	@Select("select * from tb_goods")
	public List<Goods> findAll();

}
