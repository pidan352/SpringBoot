package com.lyl.service;

import com.lyl.pojo.User;
import org.springframework.data.domain.Page;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/17
 */

public interface UserService {

	Page<User> findByPage(int pageNum, int pageSize);
}
