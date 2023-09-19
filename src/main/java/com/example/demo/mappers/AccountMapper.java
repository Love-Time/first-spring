package com.example.demo.mappers;


import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.AccountDtoResponse;
import com.example.demo.entity.Account;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @BeanMapping(resultType = AccountDtoResponse.class)
    AccountDtoResponse toDto(Account account);

    @BeanMapping(resultType = AccountDtoResponse.class)
    List<AccountDtoResponse> toDto(List<Account> account);

    Account fromDto(AccountDTO accountDTO);
}
