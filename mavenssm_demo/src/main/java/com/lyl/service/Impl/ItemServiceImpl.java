package com.lyl.service.Impl;

import com.lyl.mapper.ItemsMapper;
import com.lyl.pojo.Items;
import com.lyl.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/14
 */

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public void addItem(Items item) {
		itemsMapper.insertSelective(item);
	}

	@Override
	public List<Items> queryitems() {
		return itemsMapper.selectByExample(null);
	}
}
