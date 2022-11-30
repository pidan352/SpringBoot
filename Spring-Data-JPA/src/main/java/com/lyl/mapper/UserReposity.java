package com.lyl.mapper;

import com.lyl.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/17
 */

@Repository
public interface UserReposity extends JpaRepository<User, Integer> {

	List<User> findByUserNameLike(String username);

}
