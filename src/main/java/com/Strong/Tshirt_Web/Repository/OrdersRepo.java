package com.Strong.Tshirt_Web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Strong.Tshirt_Web.Entity.Orders;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {

}
