package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.AccountDtoResponse;
import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;

    public AccountDtoResponse create(AccountDto dto) {
        User user = userRepository.findById(dto.getUser_id()).orElse(null);
        if (user != null) {
            Account account = Account.builder()
                    .balance(0)
                    .user(user)
                    .build();
            return AccountMapper.INSTANCE.toDto(accountRepository.save(account));
        }
        return null;
    }

    public List<AccountDtoResponse> findAllByUserId(Long id){
        return AccountMapper.INSTANCE.toDto(accountRepository.findAccountByUser_Id(id));
    }

    public List<AccountDtoResponse> findAll(){
        return AccountMapper.INSTANCE.toDto(accountRepository.findAll());
    }

    public AccountDtoResponse findById(Long id){
        return AccountMapper.INSTANCE.toDto(accountRepository.findById(id).orElse(null));
    }

    public AccountDtoResponse changeBalance(Long id, double balance) {
        Account account = accountRepository.getReferenceById(id);
        if (balance>=0){
            account.setBalance(balance);
            return  AccountMapper.INSTANCE.toDto(accountRepository.save(account));
        }
        return AccountMapper.INSTANCE.toDto(account);
    }

    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
