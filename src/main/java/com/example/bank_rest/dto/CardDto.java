package com.example.bank_rest.dto;

import com.example.bank_rest.entity.Card;
import com.example.bank_rest.entity.CardStatus;
import com.example.bank_rest.util.MaskCardNumber;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CardDto {
    private String maskedNumber;
    private LocalDate expirationDate;
    private CardStatus status;
    private BigDecimal balance;
    private String username;

    public CardDto(Card card) {
        this.maskedNumber = MaskCardNumber.getMask(card.getEncryptedNumber());
        this.expirationDate = card.getExpirationDate();
        this.status = card.getStatus();
        this.balance = card.getBalance();
        this.username = card.getUser().getUsername();
    }
}
