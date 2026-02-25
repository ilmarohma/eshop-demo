package id.ac.ui.cs.advprog.eshop.service;

public interface PaymentGateway {
    boolean charge(double amount, String email);
}