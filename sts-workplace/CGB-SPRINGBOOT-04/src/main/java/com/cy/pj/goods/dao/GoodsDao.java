package com.cy.pj.goods.dao;



import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * @Mapper用于描述数据层访问接口,用于告诉mybatis框架
 * 使用次注解描述的接口要由底层创建实现类.在实现类中基于mybatisAPI实现与数据库的交互
 * */
@Mapper
public interface GoodsDao {//有的企业会把该类的名字定义为GoodsMapper
	
		
	/**在mybatis中假如sql映射语句比较简单,可以直接在dao方法上用注解方式进行定义
	 * 基于id执行删除商品信息的方法
	 * @param id 商品id
	 * @return 返回删除的行数
	 */
	@Delete("delete from tb_goods where id = #{id}")
	public int deleteById(Integer id); 
	
	@Select("select * from tb_goods")
	public List<Goods> selectAll();
	
	@Insert("insert into tb_goods values(#{id},#{name},#{remark},#{createdTime})")
	public int insertById(Goods goods);
	
	@Update("update tb_goods set name=#{name},remark=#{remark} where id=#{id}")
	public int updateById(Integer id,Goods goods);
	
	public int deleteGoods(@Param("ids")Integer... ids);
	
	@Select("select * from tb_goods where id = #{id}")
	public Goods findById(Integer id);
	
	@Update("update tb_goods set name=#{name},remark=#{remark},createdTime=#{createdTime} where id=#{id}")
	public int updateById2(Integer id,String name,String remark,Date createdTime);

}
