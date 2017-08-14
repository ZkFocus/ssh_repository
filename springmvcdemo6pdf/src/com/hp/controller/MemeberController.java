package com.hp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/memeber")
public class MemeberController {

	@RequestMapping("/center")
	public String memeberCenter(){
		
		return "/memeber/center";
	}
}
