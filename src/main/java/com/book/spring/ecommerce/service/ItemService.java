package com.book.spring.ecommerce.service;

import java.util.List;
import java.util.Map;

import com.book.spring.ecommerce.dto.ItemDto;
import com.book.spring.ecommerce.entity.Item;

public interface ItemService {
	
		public List<ItemDto> getAllListByItem();
		
		public ItemDto getItemById(Integer item_id);
		
		public ItemDto saveItem(ItemDto itemDto);
		
		 void deleteItem(Integer item_id);
		
		void updateItem(ItemDto itemDto);
		
//		public Item UpdateItemField(Integer item_id, Map<String,Object>fields);

		
	}

