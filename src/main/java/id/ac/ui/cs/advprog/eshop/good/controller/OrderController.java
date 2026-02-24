package id.ac.ui.cs.advprog.eshop.good.controller;

import id.ac.ui.cs.advprog.eshop.good.service.OrderServiceGood;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/good/order")
public class OrderController {

    private final OrderServiceGood orderService;

    public OrderController(OrderServiceGood orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/process")
    public String processOrder(
            @RequestParam List<String> items,
            @RequestParam String customerType,
            @RequestParam boolean isHoliday) {
        double total = orderService.processOrder(items, customerType, isHoliday);
        return "Order processed, total: " + total;
    }
}
