package com.example.studentlist.dto;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Nullable
public class AuthRequest {
    private String username;
    private String password;
}
