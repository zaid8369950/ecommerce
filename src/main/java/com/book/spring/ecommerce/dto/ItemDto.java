package com.book.spring.ecommerce.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto {
	
	private int itemId;
	
	@NotNull
	@NotEmpty
	private String itemName;
	
	@NotNull
	private Long itemPrice;
	private CategoryDto category;
}
