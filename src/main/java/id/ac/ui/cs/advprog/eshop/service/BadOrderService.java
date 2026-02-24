package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class BadOrderService {

    private final OrderRepository repository;
    private final JavaMailSender mailSender;

    public BadOrderService(OrderRepository repository, JavaMailSender mailSender) {
        this.repository = repository;
        this.mailSender = mailSender;
    }

    public Order processOrder(Order order) {
        if (order.getAmount() > 100) {
            order.setAmount(order.getAmount() * 0.9);
            order.setDiscountApplied(true);
        }

        Order savedOrder = repository.save(order);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(savedOrder.getCustomerEmail());
        message.setSubject("Order Confirmation");
        message.setText("Your order for Rp" + savedOrder.getAmount() + " has been processed.");
        mailSender.send(message);

        return savedOrder;
    }
}