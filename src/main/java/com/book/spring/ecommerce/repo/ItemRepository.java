package com.book.spring.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.spring.ecommerce.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{

}
