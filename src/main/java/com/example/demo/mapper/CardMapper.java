package com.example.demo.mapper;

import com.example.demo.dto.CardDtoResponse;
import com.example.demo.entity.Card;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    @BeanMapping(resultType = CardDtoResponse.class)
    CardDtoResponse toDto(Card card);
    List<CardDtoResponse> toDto(List<Card> card);

}
