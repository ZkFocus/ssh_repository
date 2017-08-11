package com.spring.future;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ClassPathXMLApplicationContext implements ApplicationContext{

	private Map<String,Object> beans=new HashMap<>();
	
	
	
	public ClassPathXMLApplicationContext() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		SAXBuilder saxBuilder=new SAXBuilder();
		
		//通过saxbuilder获取整个文档对象
		Document document=saxBuilder.build(
					this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
		//通过文档获得根元素
		Element element=document.getRootElement();
		//通过根元素获得所有的子元素
		List list=element.getChildren();
		for(int i=0;i<list.size();i++){
			//<bean id="chw" class="com.spring.old.CHello"></bean>
			Element ele=(Element) list.get(i);
			String id=ele.getAttributeValue("id");
			String clazz=ele.getAttributeValue("class");
			//根据类的全路径，利用反射创建实例
			Object o=Class.forName(clazz).newInstance();
			beans.put(id, o);
					
		}
		
	}

	@Override
	public Object getBean(String id) {
		
		return beans.get(id);
	}
	
	
}
