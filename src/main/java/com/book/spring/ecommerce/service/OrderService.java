package com.book.spring.ecommerce.service;

import java.util.List;
import java.util.Map;

import com.book.spring.ecommerce.dto.ItemDto;
import com.book.spring.ecommerce.dto.OrdersDto;
import com.book.spring.ecommerce.entity.Orders;

public interface OrderService {
	
	public OrdersDto saveOrder(OrdersDto orderDto);
	
	public List<OrdersDto>getListByOrders(OrdersDto orderDto);
	
	
	
	public OrdersDto getOrdersById(Integer order_id);
	
	
	void updateOrders(OrdersDto ordersDto);
	
//	public Orders UpdateOrdersField(Integer order_id, Map<String,Object>fields);
	
	public void deleteOrders(Integer order_id);
	
}
