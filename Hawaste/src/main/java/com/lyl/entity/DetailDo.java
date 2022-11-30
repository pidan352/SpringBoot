package com.lyl.entity;

import lombok.Data;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/25
 */

@Data
public class DetailDo extends Detail {
	private String  wasteTypeCode;     //危废类型编码
	private String wasteTypeName;    //危废类型名
	private String wasteCode;   //危废小类编码
}
