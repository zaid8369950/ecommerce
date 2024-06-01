package com.book.spring.ecommerce.mapper;

import com.book.spring.ecommerce.dto.CategoryDto;
import com.book.spring.ecommerce.dto.ItemDto;
import com.book.spring.ecommerce.entity.Category;
import com.book.spring.ecommerce.entity.Item;

public class ItemMapper {

	public static Item mapToItem(ItemDto itemDto) {
		Category category = Category.builder().categoryId(itemDto.getCategory().getCategoryId())
				.categoryName(itemDto.getCategory().getCategoryName()).build();
		Item item = Item.builder().itemId(itemDto.getItemId()).itemName(itemDto.getItemName())
				.itemPrice(itemDto.getItemPrice()).category(category).build();
		return item;
	}

	public static ItemDto mapToItemDto(Item item) {
		CategoryDto category = CategoryDto.builder().categoryId(item.getCategory().getCategoryId())
				.categoryName(item.getCategory().getCategoryName()).build();
		ItemDto itemDto = ItemDto.builder().itemId(item.getItemId()).itemName(item.getItemName())
				.itemPrice(item.getItemPrice()).category(category).build();
		return itemDto;

	}
}
