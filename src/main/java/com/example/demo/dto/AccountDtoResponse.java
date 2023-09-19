package com.example.demo.dto;

import lombok.Data;

@Data
public class AccountDtoResponse {
    private Long id;
    private double balance;
    private UserDtoResponse user;
}
