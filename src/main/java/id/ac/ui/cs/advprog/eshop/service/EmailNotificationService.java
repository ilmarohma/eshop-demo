package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {

    @Override
    public void sendOrderConfirmation(Order order) {
        // Implementation for sending email notification
        System.out.println("Sending order confirmation email for order: " + order.getId());
    }
}
