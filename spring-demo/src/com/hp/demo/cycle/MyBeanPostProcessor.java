package com.hp.demo.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
	
	// 该方法在 init 方法之前被调用
		// 可以工作返回的对象来决定最终返回给 getBean 方法的对象是哪一个, 属性值是什么
		@Override
		public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
				System.out.println("postProcessBeforeInitialization..." + bean + "," + beanName);
			return bean;
		}
	

	// 该方法在 init 方法之后被调用
	@Override
	public Object postProcessAfterInitialization(Object bean , String beanName) throws BeansException {
			System.out.println("postProcessAfterInitialization..." + bean + "," + beanName);
		return bean;
	}

	

}
