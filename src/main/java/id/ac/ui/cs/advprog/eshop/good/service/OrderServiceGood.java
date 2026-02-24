package id.ac.ui.cs.advprog.eshop.good.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceGood {

    public double processOrder(List<String> items, String customerType, boolean isHoliday) {
        validateOrder(items);
        double subtotal = calculateBaseTotal(items);
        double discountedTotal = applyDiscounts(subtotal, customerType, isHoliday);
        return applyTax(discountedTotal);
    }

    private void validateOrder(List<String> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order cannot be empty");
        }
    }

    private double calculateBaseTotal(List<String> items) {
        return items.stream().mapToDouble(this::getItemPrice).sum();
    }

    private double getItemPrice(String item) {
        switch (item) {
            case "LAPTOP": return 10000000;
            case "MOUSE": return 60000;
            case "KEYBOARD": return 1000000;
            default: return 100000;
        }
    }

    private double applyDiscounts(double total, String customerType, boolean isHoliday) {
        double finalTotal = total;
        if ("VIP".equals(customerType)) finalTotal *= 0.8;
        else if ("MEMBER".equals(customerType)) finalTotal *= 0.9;
        
        return isHoliday ? finalTotal - 50 : finalTotal;
    }

    private double applyTax(double total) {
        return total * 1.11;
    }
}