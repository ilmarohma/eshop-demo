package id.ac.ui.cs.advprog.eshop.good.service;

import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements PaymentStrategy {

	@Override
	public void pay(double amount) {
		System.out.println("Paying with credit card: " + amount);
	}

	@Override
	public boolean supports(String method) {
		return "creditcard".equalsIgnoreCase(method)
				|| "credit_card".equalsIgnoreCase(method)
				|| "credit-card".equalsIgnoreCase(method);
	}
}
