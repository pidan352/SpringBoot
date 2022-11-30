package com.lyl.service;

import com.lyl.entity.SysResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
public interface ISysResourceService extends IService<SysResource> {

	List<SysResource> selectByUserID(Long id);
}
