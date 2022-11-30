package com.lyl.service.impl;

import com.lyl.entity.SysUser;
import com.lyl.mapper.SysUserMapper;
import com.lyl.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

	@Autowired
	private SysUserMapper userMapper;

	@Override
	public SysUser findUserByUserName(String username) {

		SysUser user = userMapper.findUserByUserName(username);
		return user;
	}
}
