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
import com.book.spring.ecommerce.dto.OrdersDto;
import com.book.spring.ecommerce.entity.Orders;
import com.book.spring.ecommerce.service.OrderService;



@RestController
public class OrdersController {
	@Autowired 
	private OrderService orderService;
	
	
	//http://localhost:8080/api/orders
	@PostMapping("/api/orders")
	public ResponseEntity<OrdersDto> saveOrder(@RequestBody OrdersDto orderDto){
		return new ResponseEntity<OrdersDto>(orderService.saveOrder(orderDto), HttpStatus.OK);
		}
		
	@GetMapping("/api/orders")
	public ResponseEntity<List<OrdersDto>> getListByOrders(OrdersDto ordersDto) {
		List<OrdersDto> OrderAll=orderService.getListByOrders(ordersDto);
		return ResponseEntity.ok(OrderAll);
		
	}
	
	//http://localhost:8080/api/orders/1
	@GetMapping("/api/orders/{order_id}")
	public ResponseEntity<OrdersDto> getOrdersById(@PathVariable("order_id") Integer order_id){
		OrdersDto orderDto = orderService.getOrdersById(order_id);
		return ResponseEntity.ok(orderDto);
	}
	
	@PutMapping("/api/orders/{order_id}")
public ResponseEntity<?> updateOrders(@RequestBody OrdersDto ordersDto){
			orderService.updateOrders(ordersDto);
		return new ResponseEntity<OrdersDto>(ordersDto,HttpStatus.OK);
		
	}
	
//	@PatchMapping("/api/orders/{order_id}")
//	public Orders UpdateOrdersField(@PathVariable("order_id")Integer order_id,@RequestBody Map<String,Object>Fields) {
//		return orderService.UpdateOrdersField(order_id, Fields);	
//	}
	
	@DeleteMapping("/api/orders/{order_id}")
	public  ResponseEntity<String> deleteOrders(@PathVariable Integer order_id)  {
		orderService.deleteOrders(order_id);
		return ResponseEntity.ok("Orders is deleted successfully!");
	}
}