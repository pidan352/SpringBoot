package com.lyl.controller;

import com.lyl.pojo.Items;
import com.lyl.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/14
 */

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/queryitems")
	public ModelAndView queryitems(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		List<Items> itemList = itemService.queryitems();

		mv.addObject("itemList", itemList);
		mv.addObject("username", "张三");
		session.setAttribute("user", "张三");
		mv.setViewName("index");

		return mv;
	}

	@RequestMapping("/addItemsSubmit")
	public String addItemsSubmit(Items item) {
		itemService.addItem(item);

		return "redirect:/queryitems";
	}

}
