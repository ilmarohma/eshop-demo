package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorTest {

    private final DiscountCalculator calculator = new DiscountCalculator();

    @Test
    void shouldApply10PercentDiscountWhenAmountGreaterThan100() {
        Order order = new Order(150.0, "test@ui.ac.id");
        calculator.applyDiscount(order);
        
        assertEquals(135.0, order.getAmount());
        assertTrue(order.isDiscountApplied());
    }

    @Test
    void shouldNotApplyDiscountWhenAmountIsExactly100() {
        Order order = new Order(100.0, "test@ui.ac.id");
        calculator.applyDiscount(order);
        
        assertEquals(100.0, order.getAmount());
        assertFalse(order.isDiscountApplied());
    }
}
