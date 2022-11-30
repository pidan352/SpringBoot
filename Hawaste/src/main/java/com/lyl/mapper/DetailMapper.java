package com.lyl.mapper;

import com.lyl.entity.Detail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyl.entity.DetailDo;
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
public interface DetailMapper extends BaseMapper<Detail> {


	@Select(" SELECT\n" +
			"  de.*,\n" +
			"  w.`code` waste_type_code,\n" +
			"  wt.`name` waste_type_name,\n" +
			"  wt.`code` waste_code \n" +
			" FROM\n" +
			"  detail de,\n" +
			"  waste w,\n" +
			"  waste_type wt\n" +
			" WHERE\n" +
			"  de.work_order_id=#{oid}\n" +
			"  AND de.waste_id=w.id\n" +
			"  AND de.waste_type_id=wt.id")
	List<DetailDo> selectByOrderId(Serializable oid);

}
