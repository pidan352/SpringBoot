package com.lyl.service.impl;

import com.lyl.entity.SysResource;
import com.lyl.mapper.SysResourceMapper;
import com.lyl.service.ISysResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements ISysResourceService {

	@Override
	public List<SysResource> selectByUserID(Long id) {
		return baseMapper.selectByUserID(id);
	}
}
