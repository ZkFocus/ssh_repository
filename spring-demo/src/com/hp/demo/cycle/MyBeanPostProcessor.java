package com.hp.demo.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
	
	// �÷����� init ����֮ǰ������
		// ���Թ������صĶ������������շ��ظ� getBean �����Ķ�������һ��, ����ֵ��ʲô
		@Override
		public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
				System.out.println("postProcessBeforeInitialization..." + bean + "," + beanName);
			return bean;
		}
	

	// �÷����� init ����֮�󱻵���
	@Override
	public Object postProcessAfterInitialization(Object bean , String beanName) throws BeansException {
			System.out.println("postProcessAfterInitialization..." + bean + "," + beanName);
		return bean;
	}

	

}
