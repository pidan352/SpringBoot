package com.lyl.service;

import com.lyl.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
public interface ISysUserService extends IService<SysUser> {

	SysUser findUserByUserName(String username);
}
