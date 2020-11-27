package com.cy.pj.goods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface GoodsDao {

	@Select("select * from tb_goods")
	public List<Goods> findAll();
	
	@Delete("delete from tb_goods where id=#{id}")
	public int deleteById(Integer id);
	
	@Insert("insert into tb_goods value(null,#{name},#{remark},now())")
	public int insert(Goods good);
	
	@Select("select * from tb_goods where id=#{id}")
	public Goods findById(Integer id);
	
	@Update("update tb_goods set name=#{name},remark=#{remark},createdTime=now() where id=#{id}")
	public int updateById(Integer id,String name,String remark);
	
	@Select("select * from tb_goods where name=#{name}")
	public List<Goods> findByName(String name);
	
	@Select("select * from tb_goods where remark=#{remark}")
	public List<Goods> findByRemark(String remark);
}
