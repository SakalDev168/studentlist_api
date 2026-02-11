package com.example.studentlist.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.studentlist.dto.GlobalResponse;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/users")
@Tag(name="Home",description = "Testing home")
public class HomeController {
    @GetMapping("/home")
    public ResponseEntity<GlobalResponse<String>> home() {

    return ResponseEntity.ok(
            GlobalResponse.success(true, "Get in Home()", null)
    );
}

    @GetMapping("/check")
    public String getMethodName(@RequestParam String param) {
        return new String(param);
    }

}
