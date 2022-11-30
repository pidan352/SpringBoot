package com.lyl.mapper;

import com.lyl.pojo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/17
 */

public interface SysUserReposity extends JpaRepository<SysUser, Integer> {
}
