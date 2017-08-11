package com.hp.spring.annotion.auto;

import org.springframework.stereotype.Component;

/**
 * @Component 用于注解spring IOC容器中的bean组件
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
