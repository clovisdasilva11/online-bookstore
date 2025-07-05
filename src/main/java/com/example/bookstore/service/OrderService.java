package com.example.bookstore.service;

import com.example.bookstore.entity.Orders;
import com.example.bookstore.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final BookService bookService;

    public OrderService(OrderRepository orderRepo, BookService bookService) {
        this.orderRepo = orderRepo;
        this.bookService = bookService;
    }

    public Orders processOrder(Orders order) {
        bookService.updateStock(order.getBookId(), order.getQuantity());
        return orderRepo.save(order);
    }
}