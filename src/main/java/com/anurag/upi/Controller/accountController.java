package com.anurag.upi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/account")
@RestController
public class accountController {
@GetMapping
    public String getAccount(){
        return "Account";
    }
}
