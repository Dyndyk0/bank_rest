package com.example.bank_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("file:${user.dir}/.env")
public class BankRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankRestApplication.class, args);
	}
}
