package com.moontea.service;

import java.util.List;

import com.moontea.entity.Item;

public interface ItemService {

	public Item addItem(String itemName);

	public List<Item> getAllItem();
}
