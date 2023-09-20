package com.example.demo.controllers;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.AccountDtoResponse;
import com.example.demo.entity.Account;

import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public ResponseEntity<List<AccountDtoResponse>> getAll(){
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<AccountDtoResponse> create(AccountDTO dto){
        return new ResponseEntity<>(accountService.create(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}/user/")
    public ResponseEntity<List<AccountDtoResponse>> findByUserId(@PathVariable Long id){
        return new ResponseEntity<>(accountService.findAllByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<AccountDtoResponse> getById(@PathVariable Long id){
        return new ResponseEntity<>(accountService.findById(id), HttpStatus.OK);
    }
    @PatchMapping("/{id}/change_balance/")
    public ResponseEntity<AccountDtoResponse> changeBalance(@PathVariable Long id, double balance){
        return new ResponseEntity<>(accountService.changeBalance(id, balance), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/")
    public HttpStatus delete(@PathVariable Long id){
        accountService.delete(id);
        return HttpStatus.OK;
    }
}
