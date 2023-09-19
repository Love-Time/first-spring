package com.example.demo.dto;

import lombok.Data;

@Data
public class CardDtoResponse {

    private UserDtoResponse user;
    private AccountDtoResponse account;
}
