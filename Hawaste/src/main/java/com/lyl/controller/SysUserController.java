package com.lyl.controller;


import com.lyl.entity.SysUser;
import com.lyl.service.ISysRoleService;
import com.lyl.utils.ResponseStatus;
import com.lyl.utils.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/manager/user")
public class SysUserController {

	@Autowired
	private ISysRoleService roleService;

	@GetMapping("/selectByRid/{roleId}")
	public ResultBean<SysUser> selectByRid(@PathVariable Integer roleId) {
		List<SysUser> roleList = roleService.selectByRid(roleId);
		return ResultBean.ok(roleList);
	}

	@GetMapping("/selectNoRole/{roleId}/{oid}")
	public ResultBean<SysUser> selectNoRole(@PathVariable Integer roleId,
											@PathVariable Integer oid) {
		List<SysUser> roleList = roleService.selectNoRole(roleId, oid);
		return ResultBean.ok(roleList);
	}


}
