package com.lyl.shiro;


import com.lyl.entity.SysResource;
import com.lyl.entity.SysRole;
import com.lyl.entity.SysUser;
import com.lyl.service.ISysResourceService;
import com.lyl.service.ISysRoleService;
import com.lyl.service.ISysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/16
 */

public class ShiroRealm extends AuthorizingRealm {


	@Autowired
	private ISysUserService userService;

	@Autowired
	private ISysRoleService roleService;

	@Autowired
	private ISysResourceService resourceService;


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUser user = (SysUser) principals.getPrimaryPrincipal();

		ArrayList<String> roleList = new ArrayList<>();
		ArrayList<String> resourceList = new ArrayList<>();

		roleService.selectRoleByUserId(user.getId()).forEach(role -> {
			if (!roleList.contains(role.getName())) {
				roleList.add(role.getName());
			}
		});

		resourceService.selectByUserID(user.getId()).forEach(resource -> {
			if (!resourceList.contains(resource.getPermissionStr())) {
				resourceList.add(resource.getPermissionStr());
			}
		});

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(roleList);
		info.addStringPermissions(resourceList);

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		System.out.println(username);

		SysUser loginUser = null;
		try {
			loginUser = userService.findUserByUserName(username);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (loginUser == null) {
			return null;
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				loginUser,
				loginUser.getPassword(),
				ByteSource.Util.bytes(username),
				"ShiroRealm");


		return info;
	}
}
