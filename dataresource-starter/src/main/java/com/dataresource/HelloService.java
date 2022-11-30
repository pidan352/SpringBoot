package com.dataresource;

/**
 * 功能：实现配置的核心业务功能
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/15
 */

public class HelloService {

	private String name;
	private String msg;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String hello() {
		return this.name + "," + this.msg;
	}
}
