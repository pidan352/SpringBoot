package com.lyl.entity;

import lombok.Data;

import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/26
 */

@Data
public class SysRoleDo extends SysRole {
	private String officeName;

	private List<SysResource> resources;

	private List<SysOffice> offices;

}
