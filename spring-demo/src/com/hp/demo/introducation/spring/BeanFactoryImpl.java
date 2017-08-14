package com.hp.demo.introducation.spring;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.hp.demo.introducation.traditional.EHello;
import com.hp.demo.introducation.traditional.IHello;

public class BeanFactoryImpl implements BeanFactory{

	private Map<String,Object> beans=new HashMap<>();
	
	public BeanFactoryImpl() throws JDOMException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		
			
		SAXBuilder saxBuilder=new SAXBuilder();
		Document doc=saxBuilder.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
		Element root=doc.getRootElement();
		List list=root.getChildren();
		for(int i=0;i<list.size();i++){
			Element ele=(Element)list.get(i);
			String id=ele.getAttributeValue("id");
			String clazz=ele.getAttributeValue("class");
			Object o=Class.forName(clazz).newInstance();
			beans.put(id, o);
		}
		
	}
	
	@Override
	public Object getBean(String id) {
		return beans.get(id);
	}
	
	public static void main(String[] args) throws JDOMException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		BeanFactory beanFactory=new BeanFactoryImpl();
		IHello iHello=(EHello)beanFactory.getBean("ehello");
		iHello.sayHello();
	}
	
}
