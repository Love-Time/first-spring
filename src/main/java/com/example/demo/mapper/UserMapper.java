package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserDtoResponse;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDtoResponse toDto(User user);
    List<UserDtoResponse> toDto(List<User> users);

    User fromDto(UserDto dto);
    User fromDto(UserDtoResponse dto);

}
