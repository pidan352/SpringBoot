package com.lyl.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyl.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

	@Select(" SELECT\n" +
			"  sr.*,\n" +
			"  so.`name` office_name\n" +
			" FROM\n" +
			"  sys_role sr,\n" +
			"  sys_office so\n" +
			" ${ew.customSqlSegment}")
	IPage<SysRoleDo> selectAll(IPage<SysRoleDo> page, Wrapper ew);

	@Select("SELECT\n" +
			" su.*\n" +
			"FROM\n" +
			" sys_user su,\n" +
			" sys_user_role sur\n" +
			"WHERE\n" +
			" su.id=sur.user_id\n" +
			" AND su.del_flag=0\n" +
			" AND sur.del_flag=0\n" +
			" AND sur.role_id=#{roleId}")
	List<SysUser> selectByRid(Integer roleId);

	@Select("SELECT\n" +
			" * \n" +
			"FROM\n" +
			" sys_user \n" +
			"WHERE\n" +
			" office_id = #{oid} \n" +
			" AND id NOT IN (\n" +
			"SELECT\n" +
			" su.id \n" +
			"FROM\n" +
			" sys_user_role sur,\n" +
			" sys_user su \n" +
			"WHERE\n" +
			" sur.del_flag = 0 \n" +
			" AND su.del_flag = 0 \n" +
			" AND sur.role_id = #{roleId} \n" +
			" AND sur.user_id = su.id)")
	List<SysUser> selectNoRole(Integer roleId, Integer oid);

	@Select("SELECT\n" +
			" sre.*\n" +
			"FROM\n" +
			" sys_role sr,\n" +
			" sys_role_resource srr,\n" +
			" sys_resource sre\n" +
			"WHERE \n" +
			" sr.id=#{id}\n" +
			" AND sr.del_flag=0\n" +
			" AND srr.del_flag=0\n" +
			" AND sre.del_flag=0\n" +
			" AND sr.id=srr.role_id\n" +
			" AND srr.resource_id=sre.id")
	List<SysResource> selectRoleResource(Integer id);

	@Select("SELECT\n" +
			" so.id,\n" +
			" so.parent_id,\n" +
			" so.`name`,\n" +
			" so.icon\n" +
			"FROM\n" +
			" sys_role sr,\n" +
			" sys_role_office sro,\n" +
			" sys_office so\n" +
			"WHERE \n" +
			" sr.id=#{id}\n" +
			" AND sr.del_flag=0\n" +
			" AND sro.del_flag=0\n" +
			" AND so.del_flag=0\n" +
			" AND sr.id=sro.role_id\n" +
			" AND sro.office_id=so.id")
	List<SysOffice> selectRoleOffice(Integer id);

	@Select("SELECT\n" +
			" sr.*,\n" +
			" so.`name` office_name\n" +
			"FROM\n" +
			" sys_role sr,\n" +
			" sys_office so\n" +
			"WHERE\n" +
			" sr.id=#{id}\n" +
			" AND sr.del_flag=0\n" +
			" AND so.del_flag=0\n" +
			" AND sr.office_id=so.id")
	SysRoleDo selectOneById(Integer id);


	@Select("SELECT    \n" +
			"    sr.*  \n" +
			"FROM \n" +
			"    sys_user su,\n" +
			"    sys_user_role sur, \n" +
			"    sys_role sr  \n" +
			"WHERE  su.id = sur.user_id  \n" +
			"    AND sur.role_id = sr.id  \n" +
			"    AND su.id = #{id}\n" +
			"    AND su.del_flag = 0 \n" +
			"    AND sur.del_flag = 0 \n" +
			"    AND sr.del_flag = 0 ")
	List<SysRole> selectRoleByUserId(Long id);

}
