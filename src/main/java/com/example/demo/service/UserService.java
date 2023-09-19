package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserDtoResponse;
import com.example.demo.entity.User;
import com.example.demo.mappers.UserMapper;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDtoResponse create(UserDTO dto){
        User user = UserMapper.INSTANCE.fromDto(dto);
        return UserMapper.INSTANCE.toDto(userRepository.save(user));
    }

    public List<UserDtoResponse> readAll(){
        return UserMapper.INSTANCE.toDto(userRepository.findAll());
    }

    public UserDtoResponse findById(Long id){
        return UserMapper.INSTANCE.toDto(userRepository.findById(id).orElse(null));
    }

    public UserDtoResponse update(User user){
        return UserMapper.INSTANCE.toDto(userRepository.save(user));
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}