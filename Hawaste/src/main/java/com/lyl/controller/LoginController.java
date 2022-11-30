package com.lyl.controller;

import com.lyl.entity.SysUser;
import com.lyl.utils.ResponseStatus;
import com.lyl.utils.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/29
 */

@RestController
public class LoginController {
	@PostMapping("/doLogin")
	public ResultBean doLogin(@RequestBody Map<String, Object> params, HttpSession session) {
		String username = (String) params.get("username");
		String password = (String) params.get("password");
		System.out.println("username:" + username + ",password" + password);

		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		if (subject.isAuthenticated()) {
			SysUser sysUser = (SysUser) subject.getPrincipal();
			session.setAttribute("loginUser", sysUser);

			HashMap<String, Object> map = new HashMap<>();
			map.put("loginUser", sysUser);
			return ResultBean.ok(map);
		}
		return ResultBean.fail(ResponseStatus.USERNAME_PASS_ERROR);
	}

}
