package com.lyl.mapper;

import com.lyl.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

	@Select("SELECT\n" +
			"  *\n" +
			" FROM\n" +
			"  sys_user\n" +
			" WHERE username=#{username}")
	SysUser findUserByUserName(String username);
}
