package com.lyl.junit;

import com.dataresource.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/15
 */

//包名和java中的队形要一致
@SpringBootTest
public class TestHelloService {
	volatile

	//自动配置中已经生成了HelloService的Bean，只要不为空就是可以自动注入的
	@Autowired
	private HelloService helloService;

	//做单元测试前也是需要启动Springboot
	@Test
	public void test1() {
		String text = helloService.hello();
		System.out.println(text);

	}
}
