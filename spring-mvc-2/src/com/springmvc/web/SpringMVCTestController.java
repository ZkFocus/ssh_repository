package com.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringMVCTestController {

	/**
	 * @RequestMapping(value="",method ={"",""},headers={},params={"",""})
	 */
	
	/**
	 * ����value
	 * value :String[] ���÷��ʵ�ַ 
	 * eg��value={"/testRequestMappingValue","/testValue"}
	 * 
	 * @return
	 */
	@RequestMapping(value="testRequestMappingValue")
	public String testRequestMappingValue(){
		return "success";
	}
	
	/**
	 * method: RequestMethod[]���÷��ʷ�ʽ���ַ����飬����GET, HEAD, POST, PUT...
	 * @return
	 */
	@RequestMapping(value="testRequestMappingMethod",method=RequestMethod.GET)
	public String testRequestMappingMethod(){
		return "success";
	}
	
	/**
	 * params֧�ּ򵥵ı��ʽ���� 
	 * 	params="!name" ��������в��ܰ���name���� 
	 * 	params={"!name","age=10"} ��������в��ܰ���name������age���Ա���Ϊ10
	 * @return
	 */
	@RequestMapping(value="/testRequestMappingParams",params={"!name","password=123456"})
	public String testRequestMappingParams(){
		return "success";
	}
	
	/**
	 *  headers ���ԣ��������ƿͻ��˷���������
	 * @return
	 */
	@RequestMapping(value="/testRequestMappingHeaders",headers="Host=localhost:8080")
	public String testRequestMappingHeaders(){
		System.out.println("from host=localhost:8080");
		return "success";
	}
	
	/**
	 * 			?	ƥ���κε��ַ�
	 *			*	ƥ��0���������������ַ�
	 *			**	ƥ��0���߸����Ŀ¼
	 */
	
	/**
	 * ��ƥ�䡰/testRequestMappingAnt/abc��������ƥ�䡰/testRequestMappingAntabc��;
	 * @return
	 */
	@RequestMapping(value="/testRequestMappingAnt/*")
	public String testRequestMappingAntOne(){
		return "success";
	}
	
	
	
	
	
	/**
	 * ������������� user/1��user/2��user/3
	 * @param id
	 * @return
	 */
	/*@RequestMapping(value="/user/{id}")
	public String testRequestMappingPathVariable(@PathVariable("id")int id){
		return "success";
	}*/
	
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public String show(@PathVariable("id") Integer id) {
		System.out.println("�鿴idΪ��" + id + "��user");
		return "success";
	}
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String create() {
		System.out.println("���user");
		return "success";
	}
	//https://stackoverflow.com/questions/24673041/405-jsp-error-with-put-method
	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
	public String update(@PathVariable("id") Integer id) {
		System.out.println("����idΪ��" + id + "��user");
		return "success";
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Integer id) {
		System.out.println("ɾ��idΪ��" + id + "��user");
		return "success";
	}
	
	
}
	
