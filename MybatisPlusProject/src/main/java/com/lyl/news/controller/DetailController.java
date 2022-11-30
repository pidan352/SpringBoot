package com.lyl.news.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.lyl.news.entity.Detail;
import com.lyl.news.service.ICommentService;
import com.lyl.news.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyl
 * @since 2022-11-18
 */
@Controller
public class DetailController {

	@Autowired
	private IDetailService iDetailService;

	@Autowired
	private ICommentService iCommentService;

	//请求首页
	@RequestMapping("/listByTitle")
	public ModelAndView index(@ModelAttribute("detail") Detail detail) {
		ModelAndView mv = new ModelAndView();
		System.out.println("传入的title:" + detail.getTitle());
		if(detail.getTitle()==null){
			detail.setTitle("");
		}

		QueryWrapper<Detail> queryWrapper = new QueryWrapper<>();
		queryWrapper.like("title", detail.getTitle());
		List<Detail> detailList = iDetailService.list(queryWrapper);
		mv.addObject("newsList", detailList);
		mv.setViewName("index");

		return mv;
	}


	@RequestMapping("/deleteNews")
	public String deleteNews(Integer newsid) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("newsid", newsid);

		iCommentService.removeByMap(map);

		iDetailService.removeById(newsid);
		return "redirect:/listByTitle";
	}


}
