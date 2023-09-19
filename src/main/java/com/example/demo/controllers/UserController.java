package com.example.demo.controllers;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserDtoResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDtoResponse> create(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(userService.create(dto), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDtoResponse>> readAll(){
        return new ResponseEntity<>(userService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<UserDtoResponse> getById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
    @PatchMapping("/{id}/")
    public  ResponseEntity<UserDtoResponse> update(@RequestBody User user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/")
    public HttpStatus delete(@PathVariable Long id){
        userService.delete(id);
        return HttpStatus.OK;
    }


}
