package com.lyl.news.controller;


import com.lyl.news.entity.Comment;
import com.lyl.news.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.Oneway;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyl
 * @since 2022-11-18
 */
@Controller
public class CommentController {

	@Autowired
	private ICommentService iCommentService;

	@RequestMapping("/listComments")
	public ModelAndView listComments(Integer newsid) {
		ModelAndView mv = new ModelAndView();

		HashMap<String, Object> map = new HashMap<>();
		map.put("newsid", newsid);
		List<Comment> comments = iCommentService.listByMap(map);
		comments.forEach(System.out::println);

		mv.addObject("commentList", comments);
		mv.setViewName("comments");

		return mv;

	}

	@RequestMapping("/toAddComment")
	public ModelAndView toAddComment(Integer newsid) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("newsid", newsid);
		mv.setViewName("addComment");

		return mv;
	}

	@RequestMapping("/addComment")
	public String addComment(Comment comment){

		iCommentService.save(comment);
		return "redirect:/listByTitle";
	}

}
