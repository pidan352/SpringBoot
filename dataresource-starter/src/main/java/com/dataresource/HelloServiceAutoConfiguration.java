package com.dataresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能：实现自动配置的类，是starter的核心
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/15
 */

//表明是自动配置类
@Configuration
//读取属性类
@EnableConfigurationProperties(HelloProperties.class)
//触发自动配置类的条件，条件有多种
@ConditionalOnClass(HelloService.class)
//主要配置HelloService的实例
public class HelloServiceAutoConfiguration {

	@Autowired
	HelloProperties helloProperties;

	//声明出一个Bean，其实就是通过读取properties中相应的数据来配置需要的Bean，比如Mybatis的数据源，只需在properties中写好连接数据
	// 库的信息，就可以实现自动配置数据源，就不用手动配置MVC，web.xml等的配置了
	@Bean
	public HelloService helloService() {
		HelloService helloService = new HelloService();
		helloService.setName(helloProperties.getName());
		helloService.setMsg(helloProperties.getMsg());
		return helloService;
	}
}
