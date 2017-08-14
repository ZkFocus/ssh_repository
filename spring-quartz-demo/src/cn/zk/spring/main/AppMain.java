package cn.zk.spring.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
	public static void main(String args[]){
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("quartz-context.xml");
	}

}
