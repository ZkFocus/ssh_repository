package cn.zk.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.zk.springmvc.model.User;
import cn.zk.springmvc.repository.UserRepository;
import cn.zk.springmvc.viewresolver.PdfView;

@Controller
@RequestMapping("pdf")
public class PdfController {

	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/export")
	public ModelAndView myExcel() {
		List<User> users=userRepository.getAllUser();
		Map model = new HashMap();
		model.put("users", users);
		return new ModelAndView(new PdfView(),model);
		
	}
}
