package id.ac.ui.cs.advprog.eshop.good.service;

import id.ac.ui.cs.advprog.eshop.good.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceGood {
    
    public void registerUser(UserRegistrationDto userDto) {
        System.out.println("Registering: " + userDto.getUsername() + " from " + userDto.getCity());
    }
}