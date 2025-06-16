package com.example.bank_rest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "encrypted_number", nullable = false)
    private String encryptedNumber;

    @Getter
    @Setter
    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @Getter
    @Setter
    @Column(name = "balance")
    private BigDecimal balance;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
