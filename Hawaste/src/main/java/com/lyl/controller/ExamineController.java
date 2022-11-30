package com.lyl.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyl.entity.Examine;
import com.lyl.entity.ExamineDo;
import com.lyl.service.IExamineService;
import com.lyl.utils.PageInfo;
import com.lyl.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/manager/examine")
public class ExamineController {

	@Autowired
	private IExamineService iExamineService;

	@GetMapping("/select/{current}/{size}")
	public ResultBean<Page> select(@PathVariable Integer current,
								   @PathVariable Integer size,
								   @RequestParam Map<String, Object> params) {
		PageInfo<ExamineDo> pageInfo = new PageInfo<>(current, size);

		PageInfo<ExamineDo> page = (PageInfo<ExamineDo>) iExamineService.selectByCondition(pageInfo, params);
		page.setNavigatePage();
		return ResultBean.ok(page);
	}
}
