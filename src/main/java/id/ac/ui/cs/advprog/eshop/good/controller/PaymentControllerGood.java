package id.ac.ui.cs.advprog.eshop.good.controller;

import id.ac.ui.cs.advprog.eshop.good.service.NotificationService;
import id.ac.ui.cs.advprog.eshop.good.service.PaymentStrategy;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/good/payment")
public class PaymentControllerGood {

    private final List<PaymentStrategy> paymentStrategies;
    private final NotificationService notificationService;

    public PaymentControllerGood(List<PaymentStrategy> strategies, NotificationService notificationService) {
        this.paymentStrategies = strategies;
        this.notificationService = notificationService;
    }

    @PostMapping("/process")
    public String processPayment(@RequestParam String method, @RequestParam double amount) {
        PaymentStrategy selectedStrategy = paymentStrategies.stream()
            .filter(strategy -> strategy.supports(method))
            .findFirst()
            .orElse(null);

        if (selectedStrategy == null) {
            return "Unsupported payment method: " + method;
        }

        selectedStrategy.pay(amount);

        notificationService.notifyUser("Payment successful!");
        return "Payment processed, amount: " + amount;
    }
}