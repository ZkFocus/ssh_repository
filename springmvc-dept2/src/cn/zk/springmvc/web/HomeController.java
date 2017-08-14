package cn.zk.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller �൱����@Component  ����spring��������һ��bean
 * ����@Controller ����Ч��������
 * @author mbdn
 *
 */
@Controller
@RequestMapping("home")
public class HomeController {
	
	/**
	 * @RequestMapping
	 * 	�ȿ�������������Ҳ�������ڷ������� 
	 * 	����ӳ�������ַ ����ʽ ������� ����ͷ...
	 * @return
	 */
//	@RequestMapping(value="home",method=RequestMethod.GET)
	@RequestMapping(method=RequestMethod.GET)
	public String home(){
		/*if(model.containsAttribute("user")){
			System.out.println("model������"+model);
		}*/
		return "home";
	}
}
