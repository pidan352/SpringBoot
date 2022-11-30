package com.lyl.junit;

import com.lyl.mapper.*;
import com.lyl.pojo.*;
import com.lyl.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/17
 */

@SpringBootTest
public class JpaTest {

	@Autowired
	private UserReposity userReposity;
	@Autowired
	private UserService userService;
	@Autowired
	private FilmInfoReposity filmInfoReposity;
	@Autowired
	private FilmTypeReposity filmTypeReposity;
	@Autowired
	private SysRoleReposity sysRoleReposity;
	@Autowired
	private SysUserReposity sysUserReposity;

	@Test
	public void test1() {
		List<User> list = userReposity.findAll();
		list.forEach(li -> System.out.println(li));
	}

	@Test
	public void test2() {
		List<User> list = userReposity.findByUserNameLike("%jj%");
		list.forEach(li -> System.out.println(li));
	}

	@Test
	public void test3() {
		Page<User> page = userService.findByPage(1, 5);//第二页，从0开始算的

		page.getContent().forEach(li -> System.out.println(li));

		System.out.println("总记录数:" + page.getTotalElements());
		System.out.println("总页数:" + page.getTotalPages());
		System.out.println("pageNum" + page.getNumber());
		System.out.println("实际当前页数" + page.getNumberOfElements());
		System.out.println("单页记录数" + page.getSize());

	}


	@Test
	public void testFilmType() {
		FilmType filmType = new FilmType();
		filmType.setName("动作片");

		filmTypeReposity.save(filmType);

	}

	@Test
	public void testFilmInfo() {
		FilmInfo info = new FilmInfo();

		info.setActor("测试演员");
		info.setDirector("测试导演");
		info.setFilmName("测试电影");
		info.setTicketPrice(50d);

		info.setFilmTypes(filmTypeReposity.findById(1).get());

		filmInfoReposity.save(info);
	}


	@Test
	public void testAddUserAndRole() {
		SysUser user = new SysUser();
		user.setUserCode("mike");
		user.setPassword("000");

		SysRole role = new SysRole();
		role.setName("admin");

		//设置关联关系
		user.getSysRoles().add(role);
		role.getSysUsers().add(user);


		sysRoleReposity.save(role);
		sysUserReposity.save(user);

	}

}
