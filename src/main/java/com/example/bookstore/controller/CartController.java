package com.example.bookstore.controller;

import com.example.bookstore.entity.CartItem;
import com.example.bookstore.repository.CartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartRepository cartRepo;

    public CartController(CartRepository cartRepo) {
        this.cartRepo = cartRepo;
    }

    @GetMapping("/{username}")
    public List<CartItem> getCart(@PathVariable String username) {
        return cartRepo.findByUsername(username);
    }

    @PostMapping
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartRepo.save(item);
    }

    @DeleteMapping("/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartRepo.deleteById(id);
    }
}
