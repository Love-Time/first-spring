package com.example.demo.dto;

import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import lombok.Data;

@Data
public class CardDTO {
    private Long user_id;
    private Long account_id;
}
