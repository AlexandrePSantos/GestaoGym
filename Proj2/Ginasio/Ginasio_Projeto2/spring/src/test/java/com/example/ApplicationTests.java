package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootTest
class WebAppApplicationTests {

    @Test
    void contextLoads() {
        login();
    }

    @RequestMapping("/templates/login.html")
    public String login(){
        return "login";
    }

    @GetMapping("/templates/dashboard.html")
    public String dashboard(){
        return "dashboard";
    }

}
