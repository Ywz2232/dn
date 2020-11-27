package com.cy.pj.goods.dao;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data//此注解会在Goods类中自动添加set,get,toString等方法
/**
 * @Setter
 * @Getter
 * @ToString
 * @NoArgsConstructor
 * @AllArgsConstructor*/
public class Goods {

	private Integer id;
	private String name;
	private String remark;
	private Date createdTime;
	
}
