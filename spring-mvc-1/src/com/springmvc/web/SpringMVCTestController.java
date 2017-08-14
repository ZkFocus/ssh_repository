package com.springmvc.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.entity.User;

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
		System.out.println("RequestMapping Ant����URI�Ѿ�����......");
		return "success";
	}
	
	/**
	 * ��������testRequestParam?age=3������
	 * ������Ϊͨ��HTTP�����RPC
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping("testRequestParam")
	public String testRequestParam(@RequestParam(value="name",defaultValue="Tom")String name,@RequestParam(value="age",required=false)Integer age){
		System.out.println("testRequestParam:name->"+name+",age->"+age);
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
	
	/**
	 * �����ַ����ռλ�� ռλ��ʹ��{}������
	 * ���@PathVariableע�� ����������·���У�
	 * ����ռλ����ֵ��ʲô���ᴫ�ݵ�������������id������ȥ
	 * @param id
	 * @return
	 */
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
	
	@RequestMapping("testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language")String value){
		System.out.println("testRequestHeader:"+value);
		return "success";
	}
	
	
	
	@RequestMapping("testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID")String cookie){
		System.out.println("testCookieValue:"+cookie);
		return "success";
	}
	
	/**
	 * �����
	 * User ����ʹ�������е�ͬ�������������
	 * @param user
	 * @return
	 */
	@RequestMapping(value="testRegister",method=RequestMethod.POST)
	public String testRegister(User user){
		System.out.println("testRegister:"+user);
		//ע��ɹ�֮���ض������
		return "success";
	}
	
	@RequestMapping("restForward")
	public String testForward(){
		return "forward:/index.jsp";
	}
	
	@RequestMapping("testRedirect")
	public String testRedirect(){
		return "redirect:/index.jsp";
	}
	/**
	 * ����ģ�����ݵ���ͼ��
	 * modelʵ���Ͼ���һ��map ���ᴫ�ݸ���ͼ �������ݾ�����Ⱦ���ͻ�����
	 * ����ͼ��jsp ��ʱ�� ģ�����ݻ���Ϊ�������Է��뵽����request)֮��
	 * ��model��ʹ��map����
	 */
	@RequestMapping("list")
	public String testSendModelToJsp(Model model){
		List<User> userList=new ArrayList(){{
			add(new User("AA","111","136890"));
			add(new User("BB","222","136890"));
			add(new User("CC","333","136890"));
			add(new User("DD","444","136890"));
		}};
		model.addAttribute("userList", userList);
		return "list";
	}
	
	
}
	
