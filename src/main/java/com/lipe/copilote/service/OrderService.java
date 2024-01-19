//package com.lipe.copilote.service;
//
//import com.lipe.copilote.model.Order;
//import com.lipe.copilote.repository.OrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OrderService {
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    public List<Order> getAllOrders() {
//        return orderRepository.findAll();
//    }
//
//    public Order getOrderById(Long id) {
//        return orderRepository.findById(id).get();
//    }
//
//    public void addOrder(Order order) {
//        orderRepository.save(order);
//    }
//
//    public void deleteOrder(Long id) {
//        orderRepository.deleteById(id);
//    }
//
//}
