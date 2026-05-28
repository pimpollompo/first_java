package com.example.helpdesk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/status")
    public String status() {
        return "Application is running";
    }
}

