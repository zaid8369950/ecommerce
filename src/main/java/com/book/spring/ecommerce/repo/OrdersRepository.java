package com.book.spring.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.spring.ecommerce.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {

}
