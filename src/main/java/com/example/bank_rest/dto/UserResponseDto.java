package com.example.bank_rest.dto;

import lombok.Getter;

@Getter
public class UserResponseDto {
    private String username;
    private String role;

    public UserResponseDto(String username, String role) {
        this.username = username;
        this.role = role;
    }

}
