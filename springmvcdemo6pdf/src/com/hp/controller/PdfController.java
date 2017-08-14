package com.hp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hp.view.ViewExcel;
import com.hp.view.ViewPdf;

@Controller
@RequestMapping("/pdf")
public class PdfController {

	@RequestMapping("/mypdf")
	public ModelAndView myPdf() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("pdf");
		Map modelMap =new HashMap();
		modelMap.put("test", "123");
		modelAndView.addAllObjects(modelMap);
		return modelAndView;
	}
	
	@RequestMapping("/down")
	public ModelAndView myPdf1(HttpServletRequest request,  
            HttpServletResponse response) {
		Map model = new HashMap();
		List<String> list =new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
         model.put("list", list);      
		return new ModelAndView(new ViewPdf(),model);
	}
	
	@RequestMapping("/excel")
	public ModelAndView myExcel(HttpServletRequest request,  
            HttpServletResponse response) {
		Map model = new HashMap();
		return new ModelAndView(new ViewExcel(),model);
		
	}
}
