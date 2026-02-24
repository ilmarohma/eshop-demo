package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.service.BadOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bad-orders")
public class BadOrderController {

    private final BadOrderService badOrderService;

    public BadOrderController(BadOrderService badOrderService) {
        this.badOrderService = badOrderService;
    }

    @PostMapping
    public ResponseEntity<Order> processOrder(@RequestBody Order order) {
        Order savedOrder = badOrderService.processOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }
}
