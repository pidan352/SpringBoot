package com.lyl.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyl.entity.WorkOrderDetail;
import com.lyl.entity.WorkOrderDo;
import com.lyl.service.IWorkOrderService;
import com.lyl.utils.PageInfo;
import com.lyl.utils.ResultBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/manager/work")
public class WorkOrderController {

	@Autowired
	private IWorkOrderService workOrderService;

	@GetMapping("/select/{current}/{size}")
	@RequiresPermissions("work:select")
	public ResultBean<Page> select(@PathVariable Integer current,
								   @PathVariable Integer size,
								   @RequestParam(required = false) Map<String, Object> params) {
		PageInfo<WorkOrderDo> pageInfo = (PageInfo<WorkOrderDo>) workOrderService.selectByCondition(
				new PageInfo<>(current, size), params);
		pageInfo.setNavigatePage();
		return ResultBean.ok(pageInfo);

	}

	@GetMapping("/selectOne/{oid}")
	@RequiresPermissions("work:detail")
	public ResultBean selectOne(@PathVariable Integer oid) {
		WorkOrderDetail workOrderDetail = workOrderService.selectByOrderId(oid);
		return ResultBean.ok(workOrderDetail);
	}

}
