package com.lyl.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyl.entity.AppVersion;
import com.lyl.service.IAppVersionService;
import com.lyl.utils.PageInfo;
import com.lyl.utils.ResponseStatus;
import com.lyl.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/manager/app")
public class AppVersionController {

	@Autowired
	private IAppVersionService iAppVersionService;

	@GetMapping("/select")
	public ResultBean<Page> select(@RequestParam("current") Integer current,
								   @RequestParam("size") Integer size) {

		PageInfo<AppVersion> page = iAppVersionService.page(new PageInfo<>(current, size));
		//要设置分页对象的导航栏数据
		page.setNavigatePage();
		return ResultBean.ok(page);
	}

	@PostMapping("/saveorupdate")
	public ResultBean<Page> saveOrUpdate(@RequestBody AppVersion app) {
		System.out.println(app);
		boolean b = iAppVersionService.saveOrUpdate(app);
		if (b) {
			return ResultBean.ok();
		} else {
			return ResultBean.fail(ResponseStatus.ERROR);
		}
	}

	//查询一个对象
	@GetMapping("/selectOne")
	public ResultBean<Page> selectOne(Long id) {
		AppVersion appVersion = iAppVersionService.getById(id);
		return ResultBean.ok(appVersion);
	}


	//删除一条记录
	@GetMapping("/doDelete")
	public  ResultBean<Page> doDelete(Long id){
		boolean b = iAppVersionService.removeById(id);
		if (b) {
			return ResultBean.ok();
		} else {
			return ResultBean.fail(ResponseStatus.ERROR);
		}
	}

}
