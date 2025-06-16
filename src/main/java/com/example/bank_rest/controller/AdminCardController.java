package com.example.bank_rest.controller;

import com.example.bank_rest.dto.CardCreateDto;
import com.example.bank_rest.dto.CardDto;
import com.example.bank_rest.entity.Card;
import com.example.bank_rest.entity.CardStatus;
import com.example.bank_rest.entity.User;
import com.example.bank_rest.repository.CardRepository;
import com.example.bank_rest.repository.UserRepository;
import com.example.bank_rest.util.CardEncryptor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/admin/cards")
public class AdminCardController {
    private final CardRepository cardRepository;
    private final UserRepository userRepository;


    public AdminCardController(CardRepository cardRepository, UserRepository userRepository) {
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<CardDto> getAll() {
        return cardRepository.findAll().stream()
                .map(CardDto::new)
                .toList();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CardDto> createCard(@RequestBody CardCreateDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));



        Card card = new Card();
        card.setEncryptedNumber(CardEncryptor.encrypt(dto.getCardNumber()));
        card.setExpirationDate(dto.getExpirationDate());
        card.setStatus(CardStatus.ACTIVE);
        card.setBalance(BigDecimal.valueOf(0));
        card.setUser(user);

        Card saved = cardRepository.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CardDto(saved));
    }
}
