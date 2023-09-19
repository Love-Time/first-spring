package com.example.demo.dto;

import com.example.demo.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AccountDTO {
    private double balance;
    private Long user_id;
}
