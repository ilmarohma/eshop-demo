package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import org.springframework.stereotype.Component;

@Component
public class DiscountCalculator {
    public void applyDiscount(Order order) {
        if (order.getAmount() > 100) {
            order.setAmount(order.getAmount() * 0.9);
            order.setDiscountApplied(true);
        }
    }
}