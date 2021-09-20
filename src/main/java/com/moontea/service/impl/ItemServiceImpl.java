package com.moontea.service.impl;

import java.util.List;

import com.moontea.entity.Item;
import com.moontea.repo.ItemRepo;
import com.moontea.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// @Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepo itemRepo;

	public Item addItem(String itemName) {
		Item item = new Item();
		item.setSeri("");
		item.setItemName(itemName);
		return itemRepo.save(item);
	}

	public List<Item> getAllItem() {
		return itemRepo.findAll();
	}

}
