package com.example.bookstore.controller;

import com.example.bookstore.entity.Payment;
import com.example.bookstore.repository.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentRepository paymentRepo;

    public PaymentController(PaymentRepository paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @PostMapping
    public Payment pay(@RequestBody Payment payment) {
        payment.setTimestamp(LocalDateTime.now());
        payment.setStatus("PAID"); // mock logic
        return paymentRepo.save(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }
}
