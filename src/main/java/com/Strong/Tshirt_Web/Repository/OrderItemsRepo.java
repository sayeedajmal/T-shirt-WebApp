package com.Strong.Tshirt_Web.Repository;

import org.springframework.stereotype.Repository;

import com.Strong.Tshirt_Web.Entity.OrderItems;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
@Repository
public interface OrderItemsRepo extends JpaRepository<OrderItems, Integer> {

}
