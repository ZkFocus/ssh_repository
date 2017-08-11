package com.hp.demo.springsimulator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.hp.demo.IHello;

public class ClassPathApplicationImpl implements ClassPathApplication{

	private Map<String,Object> beans=new HashMap<>();
	
	public  ClassPathApplicationImpl() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		SAXBuilder saxBuilder=new SAXBuilder();
		
		Document document=saxBuilder.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
		
		Element root=document.getRootElement();
		
		List list=root.getChildren();
		for(int i=0;i<list.size();i++){
			Element element=(Element) list.get(i);
			String id=element.getAttributeValue("id");
			String clazz=element.getAttributeValue("class");
			System.out.println(id+"==="+clazz);
			Object o=Class.forName(clazz).newInstance();
			beans.put(id, o);
			
		}
	}
	
	@Override
	public Object getBean(String id) {
		return beans.get(id);
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, JDOMException, IOException {
		ClassPathApplication beans=new ClassPathApplicationImpl();
		IHello hello=(IHello) beans.getBean("hello");
		hello.say();
	}
}
