package com.lyl.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/17
 */

//建议：实体类的名称和属性名与数据库的名称一致
@Data
public class Users implements Serializable {
	@TableId(type = IdType.AUTO)
	protected Long id;
	protected String name;
	protected int age;
	protected String email;

	//TableField描述该字段是自动填充的，fill属性定义自动填充的时间点
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	protected Date updateTime;

	@Version
	@TableField(fill = FieldFill.INSERT)
	protected int version;

	@TableLogic //标注逻辑删除标志
	@TableField(fill = FieldFill.INSERT)
	protected int deleted;
}
