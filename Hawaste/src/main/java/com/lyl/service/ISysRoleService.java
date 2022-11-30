package com.lyl.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyl.entity.SysRole;
import com.lyl.entity.SysRoleDo;
import com.lyl.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
public interface ISysRoleService extends IService<SysRole> {

	IPage<SysRoleDo> selectAll(IPage<SysRoleDo> page, Map<String, Object> params);

	List<SysUser> selectByRid(Integer roleId);

	List<SysUser> selectNoRole(Integer roleId, Integer oid);

	SysRoleDo selectOne(Integer id);

	boolean updateById(SysRoleDo roleDo);

	List<SysRole> selectRoleByUserId(Long id);

}
