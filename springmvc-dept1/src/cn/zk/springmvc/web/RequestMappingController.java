package cn.zk.springmvc.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.zk.springmvc.entity.User;

/**
 * @Controller ��ʵ����@Component ����һģһ��
 * ����@Controller ����Ч��������
 * @author mbdn
 *
 */
@Controller
public class RequestMappingController {

	/**
	 * @RequestMapping(value="",method ={"",""},headers={},params={"",""})
	 */
	
	
	/**
	 * @RequestMapping �������ڷ����� Ҳ��������������
	 * �������������  ��Ҫ����ĳ������ķ����Ļ� 
	 * 		������ʽ�磺�����ϵ�RequestMapping + �����ϵ�RequestMapping
	 * @return
	 */
	
	@RequestMapping(value={"testRequestMappingValues","testRequestMappingValuesAgain"})
	public String testRequestMappingValues(){
		
		return "success";
	}
	
	/**
	 * Ant���
	 * 			?	ƥ���κε��ַ�
	 *			*	ƥ��0���������������ַ�
	 *			**	ƥ��0���߸����Ŀ¼
	 */
	@RequestMapping("testRequestMappingValues*")
	public String testRequestMappingValuesAnt(){
		
		return "success";
	}
	/**
	 * method��������ӳ������ķ�ʽ ����ʽ����GET PUT DELETE POST ...
	 * @return
	 */
	@RequestMapping(value="testRequestMappingMethod",method={RequestMethod.POST,RequestMethod.GET})
	public String testRequestMappingMethod(){
		
		return "success";
	}
	/**
	 * ӳ���������ͷ��Ϣ������ ���ܽ����÷���
	 * @return
	 */
	@RequestMapping(value="testRequestMappingHeaders",headers="Host=localhost:8080")
	public String testRequestMappingHeaders(){
		System.out.println("����������");
		return "success";
	}
	
	/**
	 * ͨ����������� ��������
	 * @return
	 */
	@RequestMapping(value="testRequestMappingParams",params="name!=admin")
	public String testRequestMappingParams(){
		
		return "success";
	}
	/**
	 * @RequestParam 
	 * 			name����4.2�汾�Ժ���У���������� ͬvalue
	 * 			requeired ��������Ƿ����
	 * 			defaultvalues ��������Ĭ��ֵ 
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping("testRequestParams")
	public String testRequestParams(
			@RequestParam(name="name",required=true)String name,
			@RequestParam(name="password",required=false,
				defaultValue="123456")String password
			)
	{
		System.out.println(name+"===="+password);
		return "success";
	}
	/**
	 * @RequestMapping ��������ʹ��ռλ�� ��{}��
	 * @param userid
	 * @return
	 */
	@RequestMapping("testPathVariable/{userId}")
	public String testPathVariable(
				@PathVariable("userId")Integer userid
								  ){
		System.out.println("��ȡidΪ"+userid+"��user");
		return "success";
	}
	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="testRegister",method=RequestMethod.POST)
	public String testRegister(User user,RedirectAttributes model){
		System.out.println("save user:"+user);
//		return "success";
		model.addFlashAttribute("user",user);
		return "redirect:/method";
//		return "forward:/method";
	}
	/**
	 * model ʵ���Ͼ���һ��map
	 * ��jspҳ���Ͽ���ֱ��ͨ��request���ȡ��model�е�ֵ
	 * @param model
	 * @return
	 */
	@RequestMapping("testList")
	public String testList(Model model){
		List<User> userList=new ArrayList<User>(){{
			add(new User("AA","123","111"));
			add(new User("BB","456","222"));
			add(new User("CC","789","333"));
			add(new User("DD","0AB","444"));
		}};
		model.addAttribute("userList", userList);
		
		return "list";
	}
	/**
	 * �ض���
	 * @return
	 */
	@RequestMapping("testRedirect")
	public String testRedirect(){
		
		return "redirect:/method";
	}
	/**
	 * ת��
	 * @return
	 */
	@RequestMapping("testForward")
	public String testForward(){
		
		return "forward:/method";
	}
	/**
	 * REST���Ļ�ȡ����
	 * @param id
	 * @return
	 */
	@RequestMapping("testRestGet/{id}")
	public String testRestGet(@PathVariable(name="id")Integer id){
		System.out.println("��ȡIDΪ��"+id+"��User����");
		return "success";
	}
	/**
	 * REST���ı������
	 * @param user
	 * @return
	 */
	@RequestMapping(value="testRestPost",method=RequestMethod.POST)
	public String testRestPost(User user){
		System.out.println("�������"+user);
		return "success";
	}
	/**
	 * REST�����޸�
	 * @return
	 */
	@RequestMapping(
				value="testRestPut/{id}",
				method=RequestMethod.PUT)
	public String testRestPut(@PathVariable Integer id){
		System.out.println("�޸Ķ���");
		return "success";
	}
	@RequestMapping(
				value="testRestDelete/{id}",
					method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable Integer id){
		System.out.println("ɾ������");
		return "success";
	}
	
	@RequestMapping("testView")
	public String testView(){
		
		return "helloView";
	}
	
}
