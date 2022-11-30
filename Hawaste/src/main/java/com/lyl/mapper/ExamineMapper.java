package com.lyl.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyl.entity.Examine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyl.entity.ExamineDo;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
public interface ExamineMapper extends BaseMapper<Examine> {

	@Select("SELECT " +
			" e.*," +
			" su.name user_name," +
			" so.name office_name " +
			" FROM examine e,sys_user su,sys_office so" +
			" ${ew.customSqlSegment}")
	IPage<ExamineDo> selectByCondition(IPage<ExamineDo> page, Wrapper ew);
}
