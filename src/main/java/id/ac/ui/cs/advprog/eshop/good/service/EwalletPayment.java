package id.ac.ui.cs.advprog.eshop.good.service;

import org.springframework.stereotype.Component;

@Component
public class EwalletPayment implements PaymentStrategy {

	@Override
	public void pay(double amount) {
		System.out.println("Paying with e-wallet: " + amount);
	}

	@Override
	public boolean supports(String method) {
		return "ewallet".equalsIgnoreCase(method);
	}
}
