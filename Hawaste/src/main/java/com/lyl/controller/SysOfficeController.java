package com.lyl.controller;


import com.lyl.entity.SysOffice;
import com.lyl.service.ISysOfficeService;
import com.lyl.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/manager/office")
public class SysOfficeController {

	@Autowired
	private ISysOfficeService iSysOfficeService;

	@GetMapping("/selectAll")
	public ResultBean<SysOffice> selectAll() {
		List<SysOffice> list = iSysOfficeService.list();
		return ResultBean.ok(list);
	}

}
