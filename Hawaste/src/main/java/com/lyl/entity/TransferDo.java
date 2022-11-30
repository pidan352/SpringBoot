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
public class TransferDo extends Transfer {
	private String userName;
	private String userPhone;
}
