package com.example.bank_rest.controller;

import com.example.bank_rest.dto.UserResponseDto;
import com.example.bank_rest.entity.User;
import com.example.bank_rest.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class UserController {
    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponseDto> all() {
        return repo.findAll().stream()
                .map(user -> new UserResponseDto(
                        user.getUsername(),
                        user.getRole().getName()
                ))
                .toList();
    }
}


