package com.hp.spring.annotion.auto;

import org.springframework.stereotype.Component;

/**
 * @Component ����ע��spring IOC�����е�bean���
 * <bean id="guitar" class="com.hp.spring.annotion.auto.Guitar"></bean>
 * @author Administrator
 *
 */
@Component
public class Guitar implements Performance{

	@Override
	public void perform() {
		System.out.println("Guitar.......");
		
	}
}
