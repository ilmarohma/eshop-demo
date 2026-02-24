package id.ac.ui.cs.advprog.eshop.good.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(String message) {
        System.out.println("Sending email: " + message);
    }
}