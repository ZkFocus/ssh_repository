package com.hp.spring.annotion.auto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * @Configuration java ������
 * �൱��beans.xml
 * @ComponentScan ���ɨ�� ɨ��spring IOC�����е�bean
 * @author Administrator
 *
 */
@Configuration
@ComponentScan(basePackages="com.hp.spring.annotion.auto.other")
public class AutoConfig {

}
