package com.lyl.service;

import com.lyl.pojo.Items;

import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/14
 */


public interface ItemService {
	List<Items> queryitems();

	void addItem(Items item);
}
