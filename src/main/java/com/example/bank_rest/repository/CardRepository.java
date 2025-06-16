package com.example.bank_rest.repository;

import com.example.bank_rest.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
