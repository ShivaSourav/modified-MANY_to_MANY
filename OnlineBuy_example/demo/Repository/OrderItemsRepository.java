package com.OnlineBuy_example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnlineBuy_example.demo.model.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer>{

}
