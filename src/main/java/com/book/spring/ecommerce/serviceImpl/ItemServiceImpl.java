package com.book.spring.ecommerce.serviceImpl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.book.spring.ecommerce.dto.ItemDto;
import com.book.spring.ecommerce.entity.Item;
import com.book.spring.ecommerce.exception.ItemNotFoundException;
import com.book.spring.ecommerce.mapper.ItemMapper;
import com.book.spring.ecommerce.repo.ItemRepository;
import com.book.spring.ecommerce.service.ItemService;

@Service
public class  ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemrepo;

	
	
	@Override
	public List<ItemDto> getAllListByItem() {
		List<Item> items = itemrepo.findAll();
		return items.stream().map((item) -> ItemMapper.mapToItemDto(item))
				.collect(Collectors.toList());
	}
	
	@Override
	public ItemDto getItemById(Integer item_id) {
		
		Item item = itemrepo
				.findById(item_id)
				.orElseThrow(() -> new ItemNotFoundException("item does not exists"));
		return ItemMapper.mapToItemDto(item);
	}

	@Override
	public ItemDto saveItem(ItemDto itemDto) {
		if (itemDto != null) {
			Item items = ItemMapper.mapToItem(itemDto);
			
			itemrepo.save(items);
			itemDto.setItemId(items.getItemId());
		} else {
			throw new ItemNotFoundException("No Item Data Found");
		}
		return itemDto;
	};

	
	@Override
	public void deleteItem(Integer item_id) {
		Item item = itemrepo
				.findById(item_id)
				.orElseThrow(() -> new ItemNotFoundException("Item does not exists"));
		
		itemrepo.deleteById(item_id);
	}
	
		
		@Override
		public void updateItem(ItemDto itemDto) {
			if(itemDto !=null) {
				Item item = ItemMapper.mapToItem(itemDto);
				itemrepo.save(item);
				}else {
					throw new ItemNotFoundException("Item Not Found");
				}
		}
	

//	@Override
//	public Item UpdateItemField(Integer item_id, Map<String, Object> fields) {
//		Item existingItem=itemrepo.findById(item_id).get();
//		
//		fields.forEach((key,value)->{
//		Field field=ReflectionUtils.findRequiredField(Item.class, key);
//		field.setAccessible(true);
//		ReflectionUtils.setField(field, existingItem, value);
//		});
//		
//		return itemrepo.save(existingItem);
//	}
	
	

}
