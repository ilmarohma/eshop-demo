package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;

public interface NotificationService {
    void sendOrderConfirmation(Order order);
}
