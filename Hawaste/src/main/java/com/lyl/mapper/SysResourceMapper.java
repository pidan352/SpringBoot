package com.lyl.mapper;

import com.lyl.entity.SysResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {

	@Select("   SELECT DISTINCT \n" +
			"   sre.*  \n" +
			"    FROM  \n" +
			"  sys_user sus,  \n" +
			"  sys_user_role sur,  \n" +
			"  sys_role sro,  \n" +
			"  sys_role_resource srr,  \n" +
			"  sys_resource sre   \n" +
			"    WHERE  \n" +
			" sus.id = #{id}  \n" +
			" AND sus.del_flag=0  \n" +
			" AND sur.del_flag=0  \n" +
			" AND sro.del_flag = 0   \n" +
			" AND srr.del_flag=0  \n" +
			" AND sre.del_flag = 0   \n" +
			" AND sus.id=sur.user_id  \n" +
			" AND sur.role_id = sro.id   \n" +
			" AND sro.id = srr.role_id   \n" +
			" AND srr.resource_id = sre.id")
	List<SysResource> selectByUserID(Long id);
}
