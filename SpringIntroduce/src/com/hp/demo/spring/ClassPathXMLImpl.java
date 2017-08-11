package com.hp.demo.spring;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.hp.demo.CHello;
import com.hp.demo.EHello;
import com.hp.demo.IHello;

public class ClassPathXMLImpl implements ApplicationContext{

	private Map<String, Object> beans =new HashMap<>();
	
	public ClassPathXMLImpl() throws Exception {
		//����saxbuilder����
		SAXBuilder saxBuilder=new SAXBuilder();
		
		//��ȡ�ĵ����� 
		Document document=saxBuilder.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
		
		//��ȡ��Ԫ��
		Element root =document.getRootElement();
		
		//��ȡ��Ԫ��
		List list=root.getChildren();
		
		for(int i=0;i<list.size();i++){
			//��ȡbeans����Ԫ��bean
			Element element=(Element) list.get(i);
			//��ȡbean����
			String id =element.getAttributeValue("id");
			String clazz=element.getAttributeValue("class");
//			System.out.println(id+"-----"+clazz);
			Object o=Class.forName(clazz).newInstance();
			beans.put(id, o);
		}
		
	}
	
	
	@Override
	public Object getBean(String id) {
		
		return beans.get(id);
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext ac=new ClassPathXMLImpl();
		IHello hello=(EHello)ac.getBean("hello");
		hello.say();
		
	}
}
