package com.lyl.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/14
 */

public class WebInit implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//指定spring配置类， 构建 spring容器
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(SpringMvcConfig.class);

		//配置中文编码过滤器
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		FilterRegistration.Dynamic charFilter = servletContext.addFilter("charFilter", encodingFilter);
		charFilter.addMappingForUrlPatterns(null,false,"/*");

		//配置springmvc的前端控制器
		ServletRegistration.Dynamic springmvc = servletContext.addServlet("springmvc", new DispatcherServlet(context));
		springmvc.addMapping("/");   //统一springmvc的入口
		springmvc.setLoadOnStartup(1);   // web容器启动时，首先做servlet的初始化操作（调用init方法）
	}
}
