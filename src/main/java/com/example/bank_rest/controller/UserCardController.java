package com.example.bank_rest.controller;

import com.example.bank_rest.dto.CardDto;
import com.example.bank_rest.repository.CardRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/cards")
public class UserCardController {
    private final CardRepository cardRepository;

    public UserCardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping
    public List<CardDto> getAll() {
        return cardRepository.findAll().stream()
                .map(CardDto::new)
                .toList();
    }
}
