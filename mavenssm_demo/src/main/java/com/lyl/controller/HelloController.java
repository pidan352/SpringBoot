package com.lyl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/14
 */

@Controller
public class HelloController {
	@GetMapping("/hello")
	public ModelAndView hello() {
		ArrayList<String> list = new ArrayList<>();
		list.add("张三");
		list.add("李四");
		list.add("王五");

		ModelAndView mv = new ModelAndView();

		mv.addObject("list", list);

		mv.setViewName("index");

		return mv;

	}
}
