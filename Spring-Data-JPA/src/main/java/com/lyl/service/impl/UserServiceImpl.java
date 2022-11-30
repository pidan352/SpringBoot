package com.lyl.service.impl;

import com.lyl.mapper.UserReposity;
import com.lyl.pojo.User;
import com.lyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/17
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserReposity userReposity;

	@Override
	public Page<User> findByPage(int pageNum, int pageSize) {
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		Page<User> page = userReposity.findAll(pageable);
		return page;
	}
}
