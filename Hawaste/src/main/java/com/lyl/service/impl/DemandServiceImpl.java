package com.lyl.service.impl;

import com.lyl.entity.Demand;
import com.lyl.mapper.DemandMapper;
import com.lyl.service.IDemandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户的需求填写 服务实现类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@Service
public class DemandServiceImpl extends ServiceImpl<DemandMapper, Demand> implements IDemandService {

}
