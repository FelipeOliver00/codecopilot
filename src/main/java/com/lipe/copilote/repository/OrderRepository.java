package com.lipe.copilote.repository;

import com.lipe.copilote.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
