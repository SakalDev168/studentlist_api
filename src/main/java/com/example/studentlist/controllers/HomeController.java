package com.example.studentlist.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/users")
@Tag(name="Home",description = "Testing home")
public class HomeController {
    @GetMapping("/home")
    public String Home() {
        return "welcome api!";
    }

    @GetMapping("/check")
    public String getMethodName(@RequestParam String param) {
        return new String(param);
    }

}
