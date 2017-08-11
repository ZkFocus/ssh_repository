package com.spring.aop.demo;

import org.springframework.stereotype.Component;
/**
 * component 组件 
 * 告知spring容器 该类为一组件类
	spring容器会将@Component注解的了类放入容器
 * @author mbdn
 *
 */
@Component
public class Piano implements Performance{

	@Override
	public void perform() {
		System.out.println("钢琴表演......");
//		throw new NullPointerException();
	}

	
}
