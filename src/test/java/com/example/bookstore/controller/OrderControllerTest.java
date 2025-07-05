package com.example.bookstore.controller;

import com.example.bookstore.entity.Orders;
import com.example.bookstore.service.OrderService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Test
    public void testPlaceOrder() {
        OrderService orderService = mock(OrderService.class);
        OrderController controller = new OrderController(orderService);

        Orders sampleOrder = new Orders();
        sampleOrder.setBookId(101L);
        sampleOrder.setQuantity(3);

        when(orderService.processOrder(any(Orders.class))).thenReturn(sampleOrder);

        Orders result = controller.placeOrder(sampleOrder);

        assertEquals(101L, result.getBookId());
        assertEquals(3, result.getQuantity());
    }
}