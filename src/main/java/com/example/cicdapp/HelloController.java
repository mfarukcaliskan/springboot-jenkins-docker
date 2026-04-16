package com.example.cicdapp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello() {
<<<<<<< HEAD
        return "Merhaba yaver ali";
=======
        return "Merhaba CI/CD a5";
>>>>>>> 26ae24c586bac99affc1204375390961cb6ee3c0
    }
}
