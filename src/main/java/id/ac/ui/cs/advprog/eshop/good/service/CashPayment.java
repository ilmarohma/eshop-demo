package id.ac.ui.cs.advprog.eshop.good.service;

import org.springframework.stereotype.Component;

@Component
public class CashPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pay'");
    }

    @Override
    public boolean supports(String method) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'supports'");
    }
    
}
