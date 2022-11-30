package com.lyl.mapper;

import com.lyl.entity.Transfer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyl.entity.TransferDo;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
public interface TransferMapper extends BaseMapper<Transfer> {


	@Select("SELECT\n" +
			" t.*,\n" +
			" su.`name` user_name,\n" +
			" su.phone user_phone \n" +
			"FROM\n" +
			" transfer t,\n" +
			" sys_user su\n" +
			"WHERE\n" +
			" t.work_order_id=4\n" +
			" AND t.oprate_user_id=su.id")
	List<TransferDo> selectByOrderId(Serializable oid);
}
