package com.book.spring.ecommerce.dto;

import com.book.spring.ecommerce.entity.Users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersDto {
	private Long orderId;
	@NotNull
	@NotBlank
	private String orderName;
	@NotNull
	private Long orderPrice;
	@NotNull
	private Users user;
	
}
