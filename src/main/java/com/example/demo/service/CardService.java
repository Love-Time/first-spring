package com.example.demo.service;

import com.example.demo.dto.CardDto;
import com.example.demo.dto.CardDtoResponse;
import com.example.demo.entity.Account;
import com.example.demo.entity.Card;
import com.example.demo.entity.User;
import com.example.demo.mapper.CardMapper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CardRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    public CardDtoResponse create(CardDto dto){

        User user = userRepository.findById(dto.getUser_id()).orElse(null);
        Account account = accountRepository.findById(dto.getAccount_id()).orElse(null);
        if (user!=null && account!=null){
            Card card = Card.builder()
                    .user(user)
                    .account(account)
                    .build();
            return CardMapper.INSTANCE.toDto(cardRepository.save(card));

        }
        return null;
    }

    public CardDtoResponse findById(Long id){
        return CardMapper.INSTANCE.toDto(cardRepository.findById(id).orElse(null));
    }



    public void delete(Long id){
        cardRepository.deleteById(id);
    }

    public List<CardDtoResponse> findAllByAccountId(Long id) {
        return CardMapper.INSTANCE.toDto(cardRepository.findCardByAccount_Id(id));
    }
}
