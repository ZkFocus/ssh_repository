package com.springmvc.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.entity.Product;

@Controller
@RequestMapping("/product")
public class ReqRespBodyController {


	private static final String LIST_PAGE = "productList";

	@RequestMapping
	public String list() {
		return LIST_PAGE;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(@RequestBody Product product) {
		System.out.println(product);
		return LIST_PAGE;
	}
	
	@RequestMapping(value = "/addSerial", method = RequestMethod.POST)
	public String addSerialProduct(@RequestBody List<Product> list) {
		for(Product product : list) {
			System.out.println(product);
		}
		return LIST_PAGE;
	}
	
	@RequestMapping(value = "/addBrand", method = RequestMethod.POST)
	public String addBrandProduct(@RequestBody Map<String, Product> map) {
		System.out.println(map.get("dell"));
		return LIST_PAGE;
	}
}
