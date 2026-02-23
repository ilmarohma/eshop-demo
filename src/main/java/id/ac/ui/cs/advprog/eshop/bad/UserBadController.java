package id.ac.ui.cs.advprog.eshop.bad;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bad/user")
public class UserBadController {

    private final UserServiceBad userServiceBad;

    public UserBadController(UserServiceBad userServiceBad) {
        this.userServiceBad = userServiceBad;
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String street,
            @RequestParam String city,
            @RequestParam String zipCode) {
        userServiceBad.registerUser(username, password, email, phone, street, city, zipCode);
        return "User registered: " + username;
    }
}
