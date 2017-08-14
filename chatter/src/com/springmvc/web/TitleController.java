package com.springmvc.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.data.TitleRepository;
import com.springmvc.entities.Title;

@Controller
@RequestMapping("/titles")
public class TitleController {

	private static final String MAX_LONG_AS_STRING = "9223372036854775807";

	private TitleRepository titleRepository;

	@Autowired
	public TitleController(TitleRepository titleRepository) {
		this.titleRepository = titleRepository;
	}
	/**
	 * 它并没有返回视图名称，也没有显式地设定模型，这个方法返回的是Spittle列表。当处理器方法像
		这样返回对象或集合时，这个值会放到模型中，模型的key会根据其类型推断得出（在本例中，也就是spittleList）。
		而逻辑视图的名称将会根据请求路径推断得出。因为这个方法处理针对“/spittles”的GET请求，因此视图的名称将会是spittles（去掉开头的斜线）。
	 * @param max
	 * @param count
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Title> titles(
			@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		return titleRepository.findSpittles(max, count);
	}

	//通过路径参数接受输入
	@RequestMapping(value = "/{titleId}", method = RequestMethod.GET)
	public String spittle(@PathVariable("titleId") long spittleId, Model model) {
		model.addAttribute(titleRepository.findOne(spittleId));
		return "title";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveSpittle(TitleForm form, Model model) throws Exception {
		titleRepository.save(new Title(null, form.getMessage(), new Date(), form.getLongitude(), form.getLatitude()));
		return "redirect:/titles";
	}

}
