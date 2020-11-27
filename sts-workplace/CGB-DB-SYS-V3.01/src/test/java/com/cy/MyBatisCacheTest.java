package com.cy;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisCacheTest {

	@Autowired
	private SqlSessionFactory ssf;
	
	@Test
	public void testFirstLevelCache() {
		//1.创建sqlSession对象
		SqlSession ss = ssf.openSession();
		//2.执行查询操作
		String words = "com.cy.pj.sys.dao.SysMenuDao.findObjects";
		List<Object> list = ss.selectList(words);
		ss.selectList(words);
		System.out.println(list.toString());
		//3.释放资源
		ss.close();
	}
	
	@Test
	public void testSecondLevelCache() {
		//1.创建sqlSession对象
		SqlSession ss1 = ssf.openSession();
		SqlSession ss2 = ssf.openSession();
		//2.执行查询操作
		String words = "com.cy.pj.sys.dao.SysMenuDao.findObjects";
		ss1.selectList(words);
		ss1.commit();
		ss2.selectList(words);
		
		//3.释放资源
		ss1.close();
		ss2.close();
	}
}
