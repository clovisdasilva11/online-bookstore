package com.example.bookstore.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StockNotifier {
    private static final Logger logger = LoggerFactory.getLogger(StockNotifier.class);

    public void notifyLowStock(String title, int stockLeft) {
        if (stockLeft < 5) {
            logger.warn("⚠️ Low stock for '{}': Only {} left!", title, stockLeft);
        }
    }
}