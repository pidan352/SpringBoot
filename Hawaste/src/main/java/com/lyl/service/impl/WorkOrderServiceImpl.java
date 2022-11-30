package com.lyl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.lyl.entity.WorkOrder;
import com.lyl.entity.WorkOrderDetail;
import com.lyl.entity.WorkOrderDo;
import com.lyl.mapper.DetailMapper;
import com.lyl.mapper.TransferMapper;
import com.lyl.mapper.WorkOrderMapper;
import com.lyl.service.IWorkOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
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
public class WorkOrderServiceImpl extends ServiceImpl<WorkOrderMapper, WorkOrder> implements IWorkOrderService {

	@Autowired
	private DetailMapper detailMapper;

	@Autowired
	private TransferMapper transferMapper;

	@Override
	public WorkOrderDetail selectByOrderId(Serializable oid) {
		WorkOrderDetail workOrderDetail = baseMapper.selectByOrderId(oid);
		workOrderDetail.setDetails(detailMapper.selectByOrderId(oid));
		workOrderDetail.setTransfers(transferMapper.selectByOrderId(oid));
		return workOrderDetail;
	}

	@Override
	public IPage<WorkOrderDo> selectByCondition(IPage<WorkOrderDo> page, Map<String, Object> params) {
		QueryWrapper<WorkOrderDo> wrapper = new QueryWrapper<>();

		wrapper.eq("wo.del_flag", "0")
				.eq(params.containsKey("status") && !ObjectUtils.isEmpty(params.get("status")), "wo.`status`",
					params.get("status"))
				.ge(params.containsKey("startDate") && !ObjectUtils.isEmpty(params.get("startDate")), "wo.create_date",
					params.get("startDate"))
				.le(params.containsKey("endDate") && !ObjectUtils.isEmpty(params.get("endDate")), "wo.create_date",
					params.get("endDate"))
				.and(params.containsKey("officeId") && !ObjectUtils.isEmpty(params.get("officeId")),
					 qw -> qw.eq("so.id", params.get("officeId"))
							 .or()
							 .eq("`to`.id", params.get("officeId"))
							 .or()
							 .eq("ro.id", params.get("officeId")));
		return baseMapper.selectByCondition(page, wrapper);
	}
}
