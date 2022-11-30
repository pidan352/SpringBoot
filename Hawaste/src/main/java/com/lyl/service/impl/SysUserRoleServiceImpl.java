package com.lyl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lyl.entity.SysUserRole;
import com.lyl.mapper.SysUserRoleMapper;
import com.lyl.service.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

	@Override
	public Boolean deleteBatch(Long rid, Long[] ids) {
		try {
			for (Long id : ids) {
				QueryWrapper<SysUserRole> qw = new QueryWrapper<>();
				qw.eq("role_id", rid)
						.eq("user_id", id);
				baseMapper.delete(qw);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
