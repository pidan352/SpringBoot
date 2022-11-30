package com.lyl.controller;


import com.lyl.entity.SysResource;
import com.lyl.service.ISysResourceService;
import com.lyl.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/manager/menu")
public class SysResourceController {

	@Autowired
	ISysResourceService service;

	@RequestMapping("list")
	public ResultBean<List<SysResource>> select(){
		return ResultBean.ok(service.list());
	}

}
