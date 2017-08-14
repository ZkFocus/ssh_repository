package com.springmvc.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestMultipart {

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String showRegistrationForm() {
		return "registerForm";
	}
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String processRegistration(
			@RequestPart(value = "profilePicture", required = false) 
				MultipartFile profilePicture) throws IOException {
		String filePath = "D:/java/workspace_3/spring-mvc-1/upload/" 
				+ profilePicture.getOriginalFilename();
		profilePicture.transferTo(new File(filePath));
		// FileCopyUtils.copy(profilePicture.getBytes(), new File(filePath));
		return "success";
	}
}
