package com.lyl.entity;

import lombok.Data;

import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/25
 */

@Data
public class WorkOrderDetail extends WorkOrder{

	private List<DetailDo> details;     //工单的详单信息
	private List<TransferDo> transfers;    //工单的转运记录
	private String  createUserName;     //产废用户名
	private String  createOfficeName;    //产废用户所在公司
	private String  createUserPhone;     //产废用户电话
	private String  transportUserName;   //运输用户信息
	private String  transportOfficeName;
	private String  transportUserPhone;
	private String  recipientUserName;   //处置用户信息
	private String  recipientOfficeName;
	private String  recipientUserPhone;

}
