package com.book.spring.ecommerce.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="item")
@AllArgsConstructor
@NoArgsConstructor
@Builder
 public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemId;
	private String itemName;
	private Long itemPrice;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "categoryId")
	private Category category;

	
	
	
}
