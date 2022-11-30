package com.lyl.junit;

import com.lyl.entity.Student;
import com.lyl.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.Oneway;
import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/21
 */

@SpringBootTest
public class Test1 {

	@Autowired
	private IStudentService iStudentService;

	@Test
	public void test1() {
		List<Student> list = iStudentService.list();
		list.forEach(System.out::println);
	}

}
