package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BadOrderServiceTest {

    @Mock
    private OrderRepository repository;

    @Mock
    private JavaMailSender mailSender; 

    @InjectMocks
    private BadOrderService badOrderService;

    @Test
    void testDiscountAppliedForOrdersOver100() {
        Order order = new Order(150.0, "student@ui.ac.id");
        
        when(repository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Order processed = badOrderService.processOrder(order);

        assertEquals(135.0, processed.getAmount());
        verify(mailSender).send(any(org.springframework.mail.SimpleMailMessage.class));
    }
}