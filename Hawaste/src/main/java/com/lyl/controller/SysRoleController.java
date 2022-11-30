package com.lyl.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyl.entity.SysRole;
import com.lyl.entity.SysRoleDo;
import com.lyl.entity.SysUser;
import com.lyl.entity.SysUserRole;
import com.lyl.service.ISysRoleService;
import com.lyl.service.ISysUserRoleService;
import com.lyl.utils.PageInfo;
import com.lyl.utils.ResponseStatus;
import com.lyl.utils.ResultBean;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/manager/role")
public class SysRoleController {

	@Autowired
	private ISysRoleService roleService;

	@Autowired
	private ISysUserRoleService userRoleService;

	@GetMapping("/select/{current}/{size}")
	public ResultBean<Page> select(@PathVariable Integer current,
								   @PathVariable Integer size,
								   @RequestParam(required = false) Map<String, Object> params) {

		PageInfo<SysRoleDo> pageInfo = (PageInfo<SysRoleDo>) roleService.selectAll(new PageInfo<>(current, size),
																				   params);
		pageInfo.setNavigatePage();
		return ResultBean.ok(pageInfo);
	}

	@GetMapping("/insertBatch")
	public ResultBean insertBatch(@RequestParam Long rid,
								  @RequestParam Long[] ids) {
		ArrayList<SysUserRole> list = new ArrayList<>();
		for (Long id : ids) {
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setRoleId(rid);
			sysUserRole.setUserId(id);
			list.add(sysUserRole);
		}

		boolean b = false;
		try {
			b = userRoleService.saveBatch(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (b) {
			return ResultBean.ok();
		} else {
			return ResultBean.fail(ResponseStatus.ERROR);
		}

	}


	@GetMapping("deleteBatch")
	public ResultBean deleteBatch(@RequestParam Long rid,
								  @RequestParam Long[] ids) {
		Boolean b = userRoleService.deleteBatch(rid, ids);

		if (b) {
			return ResultBean.ok();
		} else {
			return ResultBean.fail(ResponseStatus.ERROR);
		}
	}


	/**
	 * 查询角色的信息，权限信息，公司信息
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("selectOne")
	public ResultBean<SysRoleDo> selectOne(@RequestParam Integer id) {

		SysRoleDo sysRoleDo = roleService.selectOne(id);

		return ResultBean.ok(sysRoleDo);
	}


	@PostMapping("saveOrUpdate")
	public ResultBean saveOrUpdate(@RequestBody SysRoleDo roleDo) {
		boolean b = roleService.updateById(roleDo);
		if (b) {
			return ResultBean.ok();
		} else {
			return ResultBean.fail(ResponseStatus.ERROR);
		}
	}

}
