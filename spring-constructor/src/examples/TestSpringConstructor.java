package examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringConstructor {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		ExampleBean eb=(ExampleBean) ac.getBean("exampleBean");
		System.out.println(eb);
	}
}
