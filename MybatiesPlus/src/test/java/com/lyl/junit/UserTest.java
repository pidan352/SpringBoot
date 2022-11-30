package com.lyl.junit;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyl.mapper.UserMapper;
import com.lyl.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/17
 */

@SpringBootTest
public class UserTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelectUser() {
		List<Users> userList = userMapper.selectList(null);
		userList.forEach(user -> System.out.println(user));
	}

	@Test
	public void testInsertUsers() {
		Users users = new Users();
		users.setName("张三");
		users.setAge(20);
		users.setEmail("xxx@yy.com");
		int insert = userMapper.insert(users);
		System.out.println(insert);
		System.out.println(users);//id会自动回填
	}


	@Test
	public void testUpdateUsers() {
		Users user = userMapper.selectById(13);
		user.setAge(12);
		int i = userMapper.updateById(user);
		System.out.println(i);
	}


	@Test
	public void testdelteById() {
		int i = userMapper.deleteById(12);
		System.out.println(i);
	}

	@Test
	public void testdelteByNotId() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "张三");//精确
		userMapper.deleteByMap(map);
	}

	@Test
	public void testdeleteMany() {
		int i = userMapper.deleteBatchIds(Arrays.asList(4, 5));
		System.out.println(i);
	}

	@Test
	public void deleteByLuoJi() {
		int i = userMapper.deleteById(13);
		System.out.println(i);
	}

	@Test
	public void test3() {

		Page<Users> page = new Page<>(3, 2);

		userMapper.selectPage(page, null);

		page.getRecords().forEach(System.out::println);


		System.out.println("当前页：" + page.getCurrent());
		System.out.println("总页数：" + page.getPages());
		System.out.println("总记录数：" + page.getTotal());
		//System.out.println("数：" + page.getCountId());
		//System.out.println("数：" + page.getMaxLimit());
		//System.out.println("数：" + page.getSize());
	}


	@Test
	public void test4() {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("name", "Jack");
		Users users = userMapper.selectOne(queryWrapper);
		System.out.println(users);
	}

	//根据非唯一条件查询多条记录
	@Test
	public void test5(){
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.between("age",21,28);//左开右闭
		List<Users> list = userMapper.selectList(queryWrapper);
		list.forEach(users -> {
			System.out.println(users);
		});
	}

}
