package com.dataresource;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/15
 */

/**
 * 用于接受外部application.properties的参数
 */
@ConfigurationProperties(prefix = "gec.boot") //prefix用于指定改属性类识别application.properties内容的前缀
public class HelloProperties {
	private static final String DEFAULT_NAME = "gec";
	private static final String DEFAULT_MSG = "Hello World";

	private String name = DEFAULT_NAME;
	private String msg = DEFAULT_MSG;

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
}
