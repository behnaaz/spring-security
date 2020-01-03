package com.example.demo;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/welcome")
    public String all() {
        return "Hey guest!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hey admin! <br/> Principal:"+SecurityContextHolder.getContext().getAuthentication().getPrincipal()+"<br/>"+
                " Authorities: "+ SecurityContextHolder.getContext().getAuthentication().getAuthorities()+"<br/>"+
                " Name: "+ SecurityContextHolder.getContext().getAuthentication().getName()+"<br/>"+
                " Credential: "+ SecurityContextHolder.getContext().getAuthentication().getCredentials()+"<br/>"+
                " details: "+ SecurityContextHolder.getContext().getAuthentication().getDetails()+"<br/>"+
                " getAuthentication: "+ SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("/user")
    public String user() {
        return "Hey user!";
    }
}


