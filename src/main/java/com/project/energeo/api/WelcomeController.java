package com.project.energeo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Energeo - Shipping Industry Logistics Manager!";
    }

}
