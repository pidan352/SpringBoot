package com.lyl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyl.entity.Examine;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyl.entity.ExamineDo;
import com.lyl.utils.PageInfo;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
public interface IExamineService extends IService<Examine> {

	IPage<ExamineDo> selectByCondition(PageInfo<ExamineDo> page, Map<String, Object> params);
}
