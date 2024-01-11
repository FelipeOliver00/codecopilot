package com.lipe.copilote.controller;

import com.lipe.copilote.model.Order;
import com.lipe.copilote.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public String addOrder(Order order) {
        orderService.addOrder(order);
        return "Order added successfuly";
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(Long id) {
        orderService.deleteOrder(id);
        return "Order deleted successfuly";
    }

}
