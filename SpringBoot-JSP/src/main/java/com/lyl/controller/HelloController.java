package com.lyl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/15
 */

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView hello() {
		System.out.println("6666");
		ModelAndView mv = new ModelAndView();

		ArrayList<String> list = new ArrayList<>();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		mv.addObject("list", list);
		mv.setViewName("index");

		return mv;
	}
}
