package com.book.spring.ecommerce.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.spring.ecommerce.dto.ItemDto;
import com.book.spring.ecommerce.entity.Item;
import com.book.spring.ecommerce.service.ItemService;




@RestController
public class ItemController {
	@Autowired
	private ItemService itemservice;
	
	//http://localhost:8080/api/getitems
		@GetMapping("/api/getitems")
		public ResponseEntity<List<ItemDto>> getAllListByItem() {
			List<ItemDto> items = itemservice.getAllListByItem();
			return ResponseEntity.ok(items);
		}
		
	
	//http://localhost:8080/api/items/1
	@GetMapping("/api/items/{item_id}")
	public ResponseEntity<ItemDto> getItemById(@PathVariable Integer item_id){
		ItemDto itemDto = itemservice.getItemById(item_id);
		return ResponseEntity.ok(itemDto);
	}
	//http://localhost:8080/api/items
	@PostMapping("/api/items")
	public ResponseEntity<ItemDto>saveItem(@RequestBody ItemDto itemDto){
		return new ResponseEntity<ItemDto>(itemservice.saveItem(itemDto), HttpStatus.OK);
	}
	
	
		
	
	//http://localhost:8080/api/items/3
	@DeleteMapping("/api/items/{item_id}")
	public  ResponseEntity<String> deleteItem(@PathVariable Integer item_id)  {
		itemservice.deleteItem(item_id);
		return ResponseEntity.ok("Account is deleted successfully!");
	}
	
	
	
	//http://localhost:8082/api/items/1
	@PutMapping("/api/items/{item_id}")
	public ResponseEntity<?> updateItem(@RequestBody ItemDto itemDto){
		
		itemservice.updateItem(itemDto);
		return new ResponseEntity<ItemDto>(itemDto,HttpStatus.OK);
		
	}
//	//http://localhost:8082/api/items/1
//	@PatchMapping("/api/items/{item_id}")
//	public Item UpdateItemField(@PathVariable("item_id")Integer item_id,@RequestBody Map<String,Object>Fields) {
//		return itemservice.UpdateItemField(item_id, Fields);	
//	}
	

	
	
}