package id.ac.ui.cs.advprog.eshop.bad;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bad/payment")
public class PaymentControllerBad {

    @PostMapping("/process")
    public String processPayment(@RequestParam String method, @RequestParam double amount) {
        String res = "Payment processed ";
        if (method.equals("CREDIT_CARD")) {
            res += "Processing credit card for Rp" + amount;
        } else if (method.equals("E_WALLET")) {
            res += "Processing e-wallet for Rp" + amount;
        }

        System.out.println("Sending email notification: Payment successful!");

        return res;
    }
}