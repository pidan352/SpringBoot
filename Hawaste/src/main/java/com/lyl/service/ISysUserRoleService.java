package com.lyl.service;

import com.lyl.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

	Boolean deleteBatch(Long rid, Long[] ids);
}
