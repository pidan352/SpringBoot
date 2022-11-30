package com.lyl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyl.entity.WorkOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyl.entity.WorkOrderDetail;
import com.lyl.entity.WorkOrderDo;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
public interface IWorkOrderService extends IService<WorkOrder> {

	IPage<WorkOrderDo> selectByCondition(IPage<WorkOrderDo> page, Map<String, Object> params);

	WorkOrderDetail selectByOrderId(Serializable oid);
}
