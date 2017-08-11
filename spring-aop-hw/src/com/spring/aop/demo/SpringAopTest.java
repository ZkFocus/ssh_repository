package com.spring.aop.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AopConfig.class)
public class SpringAopTest {

	@Autowired
	private Performance performance;
	
	@Test
	public void test(){
		
		performance.perform();
	}
}
