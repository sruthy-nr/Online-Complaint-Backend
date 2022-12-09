package com.example.onlinecomplaint_backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnlineComplaintController {

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String Homepage(){
        return "WELCOME TO MY WEBSITE";
    }


}
