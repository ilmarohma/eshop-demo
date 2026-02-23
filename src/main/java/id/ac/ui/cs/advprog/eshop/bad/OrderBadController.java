package id.ac.ui.cs.advprog.eshop.bad;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bad/order")
public class OrderBadController {

    private final OrderServiceBad orderServiceBad;

    public OrderBadController(OrderServiceBad orderServiceBad) {
        this.orderServiceBad = orderServiceBad;
    }

    @PostMapping("/process")
    public String processOrder(@RequestParam List<String> items, @RequestParam String customerType, @RequestParam boolean isHoliday) {
        double total = orderServiceBad.processOrder(items, customerType, isHoliday);
        return "Order processed with total Rp" + total;
    }
}
