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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders {
	
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long orderId;
private String orderName;
private Long order_price;
@ManyToOne
@JoinColumn(referencedColumnName = "userId")
private Users user;
		}
	
	
	
