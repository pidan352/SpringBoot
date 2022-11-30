package com.lyl.controller;


import com.lyl.entity.Student;
import com.lyl.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyl
 * @since 2022-11-21
 */
@RestController
public class StudentController {

	@Autowired
	private IStudentService iStudentService;

	//查找所有学生数据
	@RequestMapping("/findAll")
	public List<Student> findAll() {
		List<Student> list = iStudentService.list();
		list.forEach(System.out::println);
		return list;
	}

	//修改学生信息
	@RequestMapping("/update")
	public boolean update(@RequestBody Student student) {
		System.out.println("修改的学生的id：" + student.getSid());
		return iStudentService.updateById(student);
	}

	//批量删除学生
	@RequestMapping("/removeByIds")
	public boolean removeByIds(int[] ids) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int id : ids) {
			System.out.println("要删除的id：" + id);
			list.add(id);
		}
		return iStudentService.removeByIds(list);
	}

}
