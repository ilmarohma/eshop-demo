package id.ac.ui.cs.advprog.eshop.good.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String street;
    private String city;
    private String zipCode;
}