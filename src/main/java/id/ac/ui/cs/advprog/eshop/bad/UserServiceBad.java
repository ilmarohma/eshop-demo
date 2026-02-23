package id.ac.ui.cs.advprog.eshop.bad;

import org.springframework.stereotype.Service;

@Service
public class UserServiceBad {
    
    public void registerUser(String username, String password, String email, String phone, String street, String city, String zipCode) {
        System.out.println("Registering: " + username + " from " + city);
    }
}