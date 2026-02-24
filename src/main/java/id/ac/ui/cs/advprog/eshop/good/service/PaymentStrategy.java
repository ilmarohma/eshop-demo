package id.ac.ui.cs.advprog.eshop.good.service;

public interface PaymentStrategy {
    void pay(double amount);
    boolean supports(String method);
}