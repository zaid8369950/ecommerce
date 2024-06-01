package com.book.spring.ecommerce.serviceImpl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.book.spring.ecommerce.dto.OrdersDto;
import com.book.spring.ecommerce.entity.Orders;
import com.book.spring.ecommerce.exception.OrderNotFoundException;
import com.book.spring.ecommerce.mapper.OrderMapper;
import com.book.spring.ecommerce.repo.OrdersRepository;
import com.book.spring.ecommerce.service.OrderService;

@Service
public class  OrderServiceImpl implements OrderService{

	@Autowired
	private OrdersRepository orderRepo;
	
	@Override
	public OrdersDto saveOrder(OrdersDto orderDto) {
		if (orderDto != null) {
			Orders order = OrderMapper.mapToOrders(orderDto);
			
			orderRepo.save(order);
			orderDto.setOrderId(order.getOrderId());
		} else {
			throw new OrderNotFoundException("No Order Data Found");
		}
		return orderDto;
	};


	@Override
	public List<OrdersDto> getListByOrders(OrdersDto orderDto) {
		List<Orders> orders = orderRepo.findAll();
		return orders.stream().map((order) -> OrderMapper.mapToOrdersDto(order))
				.collect(Collectors.toList());
	}

	@Override
	public OrdersDto getOrdersById(Integer order_id) {
		Orders order = orderRepo
				.findById(order_id)
				.orElseThrow(() -> new OrderNotFoundException("Order does not exists"));
		return OrderMapper.mapToOrdersDto(order);
	}

	@Override
	public void updateOrders(OrdersDto ordersDto) {
		if(ordersDto !=null) {
			Orders orders = OrderMapper.mapToOrders(ordersDto);
			orderRepo.save(orders);
			}else {
				throw new OrderNotFoundException("Order Not Found");
			}
	}

   
//	@Override
//	public Orders UpdateOrdersField(Integer order_id, Map<String, Object> fields) {
//		Orders existingOrder=orderRepo.findById(order_id).get();
//				
//		fields.forEach((key,value)->{
//		Field field=ReflectionUtils.findRequiredField(Orders.class, key);
//		field.setAccessible(true);
//		ReflectionUtils.setField(field, existingOrder, value);
//		});
//		
//		return orderRepo.save(existingOrder);
//	}
	
	 @Override
		public void deleteOrders(Integer order_id) {
		 Orders orders = orderRepo
					.findById(order_id)
					.orElseThrow(() -> new OrderNotFoundException("Order does not exists"));
			
		 orderRepo.deleteById(order_id);
		}
	

	


	


}
