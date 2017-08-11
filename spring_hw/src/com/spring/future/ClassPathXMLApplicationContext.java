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
		
		//ͨ��saxbuilder��ȡ�����ĵ�����
		Document document=saxBuilder.build(
					this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
		//ͨ���ĵ���ø�Ԫ��
		Element element=document.getRootElement();
		//ͨ����Ԫ�ػ�����е���Ԫ��
		List list=element.getChildren();
		for(int i=0;i<list.size();i++){
			//<bean id="chw" class="com.spring.old.CHello"></bean>
			Element ele=(Element) list.get(i);
			String id=ele.getAttributeValue("id");
			String clazz=ele.getAttributeValue("class");
			//�������ȫ·�������÷��䴴��ʵ��
			Object o=Class.forName(clazz).newInstance();
			beans.put(id, o);
					
		}
		
	}

	@Override
	public Object getBean(String id) {
		
		return beans.get(id);
	}
	
	
}
