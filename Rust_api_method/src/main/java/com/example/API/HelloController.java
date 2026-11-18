package com.example.API;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HelloController {

// Regisration Via the User
    @GetMapping("/registarion")
    public String Registraion() {
        return "<h1> Welcome To The Registraion  Page </h1>";


    }
//    Login End Point
    @GetMapping("/login")
    public  String Login()
    {
        return "<h1> Welcome To Login Page   </h1> ";
    }

//    Profile End  Point
    @GetMapping("/profile")
    public  String Profile()
    {
        return "<h1> User Profile </h1> ";
    }

//    Hello End Point
@GetMapping("/hello")
public  String Hello()
{
    return "<h1> User is Authanticated </h1> ";
}
}