<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"
	import="org.springframework.context.support.ClassPathXmlApplicationContext"
	import="org.springframework.context.ApplicationContext"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%

    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	
	ApplicationContext appContext = new ClassPathXmlApplicationContext();
	
	out.write( new ActionEnter( request, appContext.getResource(
			"classpath:/ueditor.config.json").getInputStream().toString()).exec());


%>