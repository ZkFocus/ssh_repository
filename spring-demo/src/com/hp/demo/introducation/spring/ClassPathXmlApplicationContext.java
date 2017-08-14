package com.hp.demo.introducation.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements BeanFactory {

	private Map<String, Object> beans = new HashMap<String, Object>();

	public ClassPathXmlApplicationContext() throws Exception {
		SAXBuilder sb = new SAXBuilder();
		// �����ĵ�����
		Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml")); 
		// ��ȡ��Ԫ��HD
		Element root = doc.getRootElement(); 
		// ȡ����Ϊdisk������Ԫ��
		List list = root.getChildren("bean");
		for (int i = 0; i < list.size(); i++) {
			Element element = (Element) list.get(i);
			String id = element.getAttributeValue("id");
			String clazz = element.getAttributeValue("class");
			//���÷��䴴��ʵ��
			Object o = Class.forName(clazz).newInstance();
			beans.put(id, o);

		}

	}

	public Object getBean(String id) {
		return beans.get(id);
	}

}
