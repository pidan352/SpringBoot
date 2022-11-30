package com.lyl.junit;

import com.lyl.entity.ExamineDo;
import com.lyl.entity.SysUser;
import com.lyl.service.IExamineService;
import com.lyl.service.ISysUserService;
import com.lyl.utils.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/23
 */

@SpringBootTest
public class Test1 {

	@Autowired
	private IExamineService iExamineService;

	@Autowired
	private ISysUserService userService;

	@Autowired
	DefaultSecurityManager securityManager;

	@Test
	public void testExamineMapper() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "%人员%");
		map.put("type", 1);
		map.put("officeId", 56);

		PageInfo<ExamineDo> page = new PageInfo<>(1, 5);
		PageInfo<ExamineDo> pageInfo = (PageInfo<ExamineDo>) iExamineService.selectByCondition(page, map);

	}

	@Test
	public void testShiro() {
		List<SysUser> list = userService.list();
		list.forEach(user -> {
			String password = "111111";
			Md5Hash md5 = new Md5Hash(password, user.getUsername(), 3);
			System.out.println(md5);
			user.setPassword(md5.toString());
			userService.saveOrUpdate(user);
		});
	}

	@Test
	public void testLogin() {
		SecurityUtils.setSecurityManager(securityManager);
		//获取主体
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "111111");
		subject.login(token);

		System.out.println("是否是合法用户：" + subject.isAuthenticated());

		subject.logout();

		System.out.println("是否是合法用户：" + subject.isAuthenticated());

	}
}
