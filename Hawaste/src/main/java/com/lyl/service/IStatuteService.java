package com.lyl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyl.entity.Statute;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
public interface IStatuteService extends IService<Statute> {

	IPage<Statute> selectByCondition(IPage<Statute> page, Integer type);

}
