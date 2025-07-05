package com.example.bookstore.controller;

import com.example.bookstore.entity.Orders;
import com.example.bookstore.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Orders placeOrder(@RequestBody Orders order) {
        return orderService.processOrder(order);
    }
}