package com.customer.order.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.order.model.Order;
import com.customer.order.services.OrderService;

public class OrderController {
    public OrderService orderService; 
    public Order createOrder(@RequestBody Order order){
            return orderService.saveOrder(order);
    }

    public List<Order> listOrder(@RequestParam String customerOrder){
         return null;
    }
}
