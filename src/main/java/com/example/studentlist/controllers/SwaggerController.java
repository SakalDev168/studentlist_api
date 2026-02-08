package com.example.studentlist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping("/")
    public String toSwagger() {
        return "redirect:/swagger-ui/index.html";
    }
}
