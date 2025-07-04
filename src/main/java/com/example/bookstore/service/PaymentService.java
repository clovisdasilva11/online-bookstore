package com.example.bookstore.service;

import com.example.bookstore.entity.Payment;
import com.example.bookstore.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepo;

    public PaymentService(PaymentRepository paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    public Payment processPayment(Payment payment) {
        payment.setTimestamp(LocalDateTime.now());
        payment.setStatus("SUCCESS");
        return paymentRepo.save(payment);
    }
}