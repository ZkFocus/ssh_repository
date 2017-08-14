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
	 * ����û�з�����ͼ���ƣ�Ҳû����ʽ���趨ģ�ͣ�����������ص���Spittle�б���������������
		�������ض���򼯺�ʱ�����ֵ��ŵ�ģ���У�ģ�͵�key������������ƶϵó����ڱ����У�Ҳ����spittleList����
		���߼���ͼ�����ƽ����������·���ƶϵó�����Ϊ�������������ԡ�/spittles����GET���������ͼ�����ƽ�����spittles��ȥ����ͷ��б�ߣ���
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

	//ͨ��·��������������
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
