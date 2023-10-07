package com.example.demo.controller;

import com.example.demo.dto.CardDto;
import com.example.demo.dto.CardDtoResponse;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping("/")
    public ResponseEntity<CardDtoResponse> create(@RequestBody CardDto dto){
        return new ResponseEntity<>(cardService.create(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<CardDtoResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(cardService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/account/")
    public ResponseEntity<List<CardDtoResponse>> findAllByAccountId(@PathVariable Long id){
        return new ResponseEntity<>(cardService.findAllByAccountId(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}/")
    public HttpStatus delete(@PathVariable Long id){
        cardService.delete(id);
        return HttpStatus.OK;
    }
}
