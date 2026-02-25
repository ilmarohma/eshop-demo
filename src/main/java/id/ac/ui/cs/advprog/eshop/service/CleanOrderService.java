package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CleanOrderService {

    private final OrderRepository repository;
    private final DiscountCalculator discountCalculator;
    private final NotificationService notificationService;

    public CleanOrderService(OrderRepository repository, 
                             DiscountCalculator discountCalculator, 
                             NotificationService notificationService) {
        this.repository = repository;
        this.discountCalculator = discountCalculator;
        this.notificationService = notificationService;
    }

    public Order processOrder(Order order) {
        discountCalculator.applyDiscount(order);
        Order savedOrder = repository.save(order);
        notificationService.sendOrderConfirmation(savedOrder);
        return savedOrder;
    }
}