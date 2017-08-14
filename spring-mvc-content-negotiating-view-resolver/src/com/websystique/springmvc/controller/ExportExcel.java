package com.websystique.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.websystique.springmvc.viewresolver.ExcelView;

@Controller
@RequestMapping("export")
public class ExportExcel {

	@RequestMapping("exportExcel")
	public ModelAndView exportExcel(){
		ExcelView ev=new ExcelView();
		ModelAndView mv=new ModelAndView(ev);
		return mv;
	}
}
