package id.ac.ui.cs.advprog.eshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_orders")
public class Order {
    @Id @GeneratedValue
    private Long id;
    private double amount;
    private String customerEmail;
    private boolean isDiscountApplied;

    public Order() {}

    public Order(double amount, String customerEmail) {
        this.amount = amount;
        this.customerEmail = customerEmail;
    }

    public Long getId() { return id; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getCustomerEmail() { return customerEmail; }
    public boolean isDiscountApplied() { return isDiscountApplied; }
    public void setDiscountApplied(boolean discountApplied) { this.isDiscountApplied = discountApplied; }
}