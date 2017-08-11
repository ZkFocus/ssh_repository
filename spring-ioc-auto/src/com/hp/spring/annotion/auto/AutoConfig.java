package com.hp.spring.annotion.auto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * @Configuration java 配置类
 * 相当于beans.xml
 * @ComponentScan 组件扫描 扫描spring IOC容器中的bean
 * @author Administrator
 *
 */
@Configuration
@ComponentScan(basePackages="com.hp.spring.annotion.auto.other")
public class AutoConfig {

}
