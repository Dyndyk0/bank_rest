package com.example.bank_rest.util;

public class MaskCardNumber {
    public static String getMask(String number) {
        String decryptNumber = CardEncryptor.decrypt(number);
        return "**** **** **** " + decryptNumber.substring(decryptNumber.length() - 4);
    }
}
