package com.moontea.controller;

import java.util.List;

import javax.transaction.Transactional;

import com.moontea.entity.Item;
import com.moontea.service.ItemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemController {

	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private ItemService itemService;

	@PostMapping("/addItem")
	public Item addItem(@RequestParam("itemName") String itemName) {
		return itemService.addItem(itemName);
	}

	@PostMapping("/getAllItem")
	public List<Item> getAllItem() {
		return itemService.getAllItem();
	}

}
