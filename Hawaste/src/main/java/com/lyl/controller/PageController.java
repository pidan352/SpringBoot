package com.lyl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/22
 */

@Controller
public class PageController {

	/**
	 * 一级路径页面跳转
	 *
	 * @param url
	 * @return
	 */
	@GetMapping("{url}.html")
	public String module1(@PathVariable String url) {
		return url;
	}

	/**
	 * 二级路径页面跳转
	 *
	 * @param url
	 * @return
	 */
	@GetMapping("/manager/{url}.html")
	public String module2( @PathVariable("url") String url) {
		return  "/manager/" + url;
	}

	/**
	 * 三级路径页面跳转:  /manager/app/app.html
	 *
	 * @param url
	 * @return
	 */
	@GetMapping("{module}/{classify}/{url}.html")
	public String module3(@PathVariable("module") String module,
						  @PathVariable("classify") String classify,
						  @PathVariable("url") String url) {

		return module + "/" + classify + "/" + url;
	}

	/**
	 * 四级级路径页面跳转:
	 *
	 * @param url
	 * @return
	 */
	@GetMapping("/manager/{classify}/{three}/{url}.html")
	public String module4(@PathVariable("classify") String classify,
						  @PathVariable("three") String three,
						  @PathVariable("url") String url) {
		return "/manager/" + classify + "/" + three + "/" + url;
	}
}
