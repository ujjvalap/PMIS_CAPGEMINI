package com.springboot.server.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/v1")
public class HelloWord {
    @GetMapping("/login")
    public String Login()
    {
        return "<h1> Hello Login Page </h1>";
    }

    @GetMapping("/home")
    public String Home()
    {
        return "<h1> Hello Home Page </h1>";
    }

}
