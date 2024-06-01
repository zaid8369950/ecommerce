package com.book.spring.ecommerce.mapper;

import com.book.spring.ecommerce.dto.OrdersDto;
import com.book.spring.ecommerce.entity.Orders;

public class OrderMapper {

	public static Orders mapToOrders(OrdersDto orderDto) {

		return Orders.builder().orderId(orderDto.getOrderId()).orderName(orderDto.getOrderName())
				.order_price(orderDto.getOrderPrice()).user(orderDto.getUser()).build();

	}

	public static OrdersDto mapToOrdersDto(Orders order) {

		return OrdersDto.builder().orderId(order.getOrderId()).orderName(order.getOrderName())
				.orderPrice(order.getOrder_price()).user(order.getUser()).build();

	}
}
