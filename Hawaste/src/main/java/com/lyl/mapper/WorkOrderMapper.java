package com.lyl.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyl.entity.WorkOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyl.entity.WorkOrderDetail;
import com.lyl.entity.WorkOrderDo;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
public interface WorkOrderMapper extends BaseMapper<WorkOrder> {

	@Select("SELECT\n" +
			" wo.*,\n" +
			" cu.NAME create_user_name,\n" +
			" so.NAME create_office_name,\n" +
			" tu.NAME transport_user_name,\n" +
			" ru.NAME recipient_user_name \n" +
			" FROM \n" +
			" work_order wo\n" +
			" #产废方\n" +
			" LEFT JOIN sys_user cu ON wo.create_user_id=cu.id\n" +
			" #产废方单位\n" +
			" LEFT JOIN sys_office so ON cu.office_id=so.id\n" +
			" #运输方\n" +
			" LEFT JOIN sys_user tu ON wo.transport_user_id=tu.id\n" +
			" #运输方单位\n" +
			" LEFT JOIN sys_office `to` ON tu.office_id=`to`.id\n" +
			" #处废方\n" +
			" LEFT JOIN sys_user ru ON wo.recipient_user_id=ru.id\n" +
			" #处废方单位\n" +
			" LEFT JOIN sys_office ro ON ru.office_id=ro.id " +
			" ${ew.customSqlSegment}")
	IPage<WorkOrderDo> selectByCondition(IPage<WorkOrderDo> page, Wrapper ew);


	@Select("SELECT\n" +
			" wo.*,\n" +
			" cu.NAME create_user_name,\n" +
			" cu.phone create_user_phone,\n" +
			" so.NAME create_office_name,\n" +
			" tu.NAME transport_user_name,\n" +
			" tu.phone transport_user_phone,\n" +
			" `to`.`name` transport_office_name,\n" +
			" ru.NAME recipient_user_name,\n" +
			" ru.phone recipient_user_phone,\n" +
			" ro.`name` recipient_office_name \n" +
			"FROM \n" +
			" work_order wo\n" +
			" #产废方\n" +
			" LEFT JOIN sys_user cu ON wo.create_user_id=cu.id \n" +
			" #产废方单位\n" +
			" LEFT JOIN sys_office so ON cu.office_id=so.id\n" +
			" #运输方\n" +
			" LEFT JOIN sys_user tu ON wo.transport_user_id=tu.id\n" +
			" #运输方单位\n" +
			" LEFT JOIN sys_office `to` ON tu.office_id=`to`.id\n" +
			" #处废方\n" +
			" LEFT JOIN sys_user ru ON wo.recipient_user_id=ru.id\n" +
			" #处废方单位\n" +
			" LEFT JOIN sys_office ro ON ru.office_id=ro.id\n" +
			"WHERE\n" +
			" wo.del_flag=0\n" +
			" AND wo.id=#{oid}")
	WorkOrderDetail selectByOrderId(Serializable oid);
}
