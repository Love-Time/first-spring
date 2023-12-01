package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserDtoResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDtoResponse> create(@RequestBody UserDto dto) {
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
    public  ResponseEntity<UserDtoResponse> update(@PathVariable Long id, @RequestBody UserDto userDTO){
        return new ResponseEntity<>(userService.update(id, userDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/")
    public HttpStatus delete(@PathVariable Long id){
        userService.delete(id);
        return HttpStatus.OK;
    }


}
