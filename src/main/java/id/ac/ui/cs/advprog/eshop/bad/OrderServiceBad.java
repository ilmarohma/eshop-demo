package id.ac.ui.cs.advprog.eshop.bad;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceBad {

    public double processOrder(List<String> items, String customerType, boolean isHoliday) {
        double total = 0;
        
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order cannot be empty");
        }

        for (String item : items) {
            if (item.equals("LAPTOP")) {
                total += 10000000;
            } else if (item.equals("MOUSE")) {
                total += 60000;
            } else if (item.equals("KEYBOARD")) {
                total += 1000000;
            } else {
                total += 100000;
            }
        }

        if (customerType.equals("VIP")) {
            total = total * 0.8; // Diskon 20%
        } else if (customerType.equals("MEMBER")) {
            total = total * 0.9; // Diskon 10%
        }

        if (isHoliday) {
            total = total - 50; 
        }

        double tax = total * 0.11;
        total += tax;

        return total;
    }
}