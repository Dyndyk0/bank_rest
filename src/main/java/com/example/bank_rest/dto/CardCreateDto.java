package com.example.bank_rest.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class CardCreateDto {
    private String cardNumber;
    private LocalDate expirationDate;
    private Long userId;
}
