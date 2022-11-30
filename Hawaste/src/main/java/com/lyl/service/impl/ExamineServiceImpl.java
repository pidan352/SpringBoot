package com.lyl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.lyl.entity.Examine;
import com.lyl.entity.ExamineDo;
import com.lyl.mapper.ExamineMapper;
import com.lyl.service.IExamineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyl.utils.PageInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@Service
public class ExamineServiceImpl extends ServiceImpl<ExamineMapper, Examine> implements IExamineService {

	@Override
	public IPage<ExamineDo> selectByCondition(PageInfo<ExamineDo> page, Map<String, Object> params) {
		QueryWrapper<ExamineDo> query = new QueryWrapper<>();

		//拼接固定sql条件
		query.apply("e.del_flag=0 AND e.examine_user_id=su.id AND su.office_id=so.id")
				//拼接动态sql条件
				.eq(params.containsKey("type") && !ObjectUtils.isEmpty(params.get("type")), "e.type", params.get(
						"type"))
				.eq(params.containsKey("officeId") && !ObjectUtils.isEmpty(params.get("officeId")), "so.id",
					params.get("officeId"))
				.like(params.containsKey("name") && !ObjectUtils.isEmpty(params.get("name")), "su.name",
					  params.get("name"));

		return baseMapper.selectByCondition(page, query);
	}
}
