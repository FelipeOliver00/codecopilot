package com.lipe.copilote.controller;

import com.lipe.copilote.model.Order;
import com.lipe.copilote.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    public void testGetOrders() {
        when(orderService.getAllOrders()).
                thenReturn(List.of(new Order(1L, 1L, 1L, 1, 1L, "NEW" )));
        var orders = orderController.getOrders();
        Assertions.assertEquals(1, orders.size());
    }

    @Test
    public void testGetOrder() {
        when(orderService.getOrderById(1L)).
                thenReturn(new Order(1L, 1L, 1L, 1, 1L, "NEW" ));
        var order = orderController.getOrder(1L);
        Assertions.assertEquals(1L, order.getId());
    }

    @Test
    public void testAddOrder() {
        Order order = new Order(1L, 1L, 1L, 1, 1L, "NEW" );
        Assertions.assertEquals("Order added successfuly", orderController.addOrder(order));
    }

    @Test
    public void testDeleteOrder() {
        var order = orderController.deleteOrder(1L);
        Assertions.assertEquals("Order deleted successfuly", order);
    }

}