package com.example.bookstore.service;

import com.example.bookstore.entity.CartItem;
import com.example.bookstore.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepo;

    public CartService(CartRepository cartRepo) {
        this.cartRepo = cartRepo;
    }

    public List<CartItem> getCartItems(String username) {
        return cartRepo.findByUsername(username);
    }

    public void clearCart(String username) {
        List<CartItem> items = cartRepo.findByUsername(username);
        cartRepo.deleteAll(items);
    }
}
