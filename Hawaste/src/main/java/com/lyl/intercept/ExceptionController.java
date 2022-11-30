package com.lyl.intercept;

import com.lyl.utils.ResultBean;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/29
 */

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(AuthorizationException.class)
	public ResultBean handlerException1(AuthorizationException e) {
		ResultBean error = ResultBean.error();
		error.setMsg("该用户无权访问该功能");
		return error;
	}

	@ExceptionHandler({IncorrectCredentialsException.class, UnknownAccountException.class})
	public ResultBean handlerException2(Exception e) {
		ResultBean error = ResultBean.error();
		error.setMsg("账号或密码错误");
		return error;
	}
}
