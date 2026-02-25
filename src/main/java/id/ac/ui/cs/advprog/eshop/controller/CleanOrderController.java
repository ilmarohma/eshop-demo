package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.service.CleanOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clean-orders")
public class CleanOrderController {

    private final CleanOrderService cleanOrderService;

    public CleanOrderController(CleanOrderService cleanOrderService) {
        this.cleanOrderService = cleanOrderService;
    }

    @PostMapping
    public ResponseEntity<Order> processOrder(@RequestBody Order order) {
        Order savedOrder = cleanOrderService.processOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }
}
