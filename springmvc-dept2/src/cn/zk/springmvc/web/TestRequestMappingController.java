package cn.zk.springmvc.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.zk.springmvc.entity.User;

@Controller
public class TestRequestMappingController {
	/**
	 * ���ʵ�ַΪ��
	 * 		�����ϼ���@RequestMapping("springmvc")
	 * 		http://localhost:8080/springmvc-dept2/
	 * 				springmvc/testRequestMappingValues
	 * 		������û��@RequestMapping
	 * 		http://localhost:8080/springmvc-dept2/
	 * 				testRequestMappingValues
	 * @return
	 */
	@RequestMapping(value="testRequestMappingValues")
	public String testRequestMappingValues(){
		
		return "success";
	}
	
	@RequestMapping(value={"testRequestMappingValues","testValues"})
	public String testRequestMappingValuesArrays(){
		
		return "success";
	}
	/**
	 * Ant���
	 * 			?	ƥ���κε��ַ�
	 *			*	ƥ��0���������������ַ�
	 *			**	ƥ��0���߸����Ŀ¼
	 */
	@RequestMapping("testRequestMappingValuesAnt*")
	public String testRequestMappingValuesAnt(){
		
		return "success";
	}
	/**
	 * method ָ������ķ�ʽ 
	 * 		GET POST DELETE PUT...
	 * @return
	 */
	@RequestMapping(value="testMethod",method=RequestMethod.POST)
	public String testRequestMappingMethod(){
		return "success";
	}
	/**
	 * ָ��HTTP����ͷ�ĸ�ʽ
	 * @return
	 */
	@RequestMapping(value="testHeaders",headers="Accept-Language=en-US,zh-CN;q=0.8,zh;q=0.6,en;q=0.4")
	public String testRequestMappingHeader(){
		return "success";
	}
	/**
	 * params�޶����ʲ���
	 * @return
	 */
	@RequestMapping(value="testRequestMappingParams",
			params="name!=root")
	public String testRequestMappingParams(){
		
		return "success";
	}
	/**
	 * @RequestParam ���ڻ�ȡ����·���еĲ���
	 * 			name:����ӳ������·���еĲ�������
	 * 			required:Ĭ��Ϊtrue 
	 * 			defaultValue������ָ��Ĭ��ֵ
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping("testRequestParams")
	public String testRequestParams(
					@RequestParam(name="name")String name,
					@RequestParam(name="password",required=false,
						defaultValue="123456")String password){
		System.out.println(name+"==="+password);
		return "success";
	}
	/**
	 * REST ����API 
	 * ����·����ʹ��{}��ʾռλ�� �������磺getUser/123 getUser/345 ������
	 * @param userId
	 * @return
	 */
	@RequestMapping("getUser/{userId}")
	public String testPathVariable(@PathVariable(name="userId")Integer userId){
		System.out.println("��ȡid Ϊ"+userId+"���û�");
		return "success";
	}
	
	/**
	 *  ���������������к� �������е��β�һģһ���Ĳ����Ļ� ������βν��и�ֵ
	 * @param user
	 * @return
	 */
	@RequestMapping(value="testRegister",method=RequestMethod.POST)
	public String testRegister(User user,RedirectAttributes model){
		System.out.println(user);
//		return "success";
		model.addFlashAttribute("user", user);
		return "redirect:/home";
//		return "forward:/home";
	}
	/**
	 * model.addAttribute("userList", userList);
	 * ��jspҳ���� ����ֱ��ͨ��request����ȡ��
	 * @param model
	 * @return
	 */
	@RequestMapping("testListUsers")
	public String testListUsers(Model model){
		List<User> userList=new ArrayList<User>(){{
			add(new User("AA","111","123"));
			add(new User("BB","222","123"));
			add(new User("CC","333","123"));
		}};
		model.addAttribute("userList", userList);
		return "list";
	}
	
	@RequestMapping("testView")
	public String testView(){
		
		return "helloView";
	}
	/**
	 * ����REST����API get����
	 */
	@RequestMapping("testRestGet/{id}")
	public String testRestGet(@PathVariable Integer id){
		System.out.println("Get user from DB where id is "+id);
		return "success";
	}
	/**
	 * ����REST����API POST����
	 */
	@RequestMapping(value="testRestPost",method=RequestMethod.POST)
	public String testRestPost(User user){
		System.out.println("���棺"+user);
		return "success";
	}
	/**
	 * ����REST����API PUT����
	 */
	@RequestMapping(value="testRestPut/{id}",method=RequestMethod.PUT)
	public String testRestPut(@PathVariable Integer id){
		System.out.println("Put idΪ��"+id+"�Ķ���");
		return "success";
	}
	/**
	 * ����REST����API DELETE����
	 */
	@RequestMapping(value="testRestDelete/{id}",method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable Integer id){
		System.out.println("Delete idΪ��"+id+"�Ķ���");
		return "success";
	}
	
}
