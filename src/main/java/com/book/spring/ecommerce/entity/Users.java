package com.book.spring.ecommerce.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  private Integer userId;
  private String userName;
  @OneToMany(mappedBy = "user")
  List<Orders> order;
	
}
