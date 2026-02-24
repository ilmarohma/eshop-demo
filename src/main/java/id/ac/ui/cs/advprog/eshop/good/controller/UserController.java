package id.ac.ui.cs.advprog.eshop.good.controller;

import id.ac.ui.cs.advprog.eshop.good.dto.UserRegistrationDto;
import id.ac.ui.cs.advprog.eshop.good.service.UserServiceGood;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/good/user")
public class UserController {

    private final UserServiceGood userService;

    public UserController(UserServiceGood userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegistrationDto userDto) {
        userService.registerUser(userDto);
        return "User registered: " + userDto.getUsername();
    }
}
