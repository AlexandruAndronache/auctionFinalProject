package com.sda.auction.controller;

import com.sda.auction.dto.UserDto;
import com.sda.auction.model.User;
import com.sda.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/register")
public class Registration {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<String> get () {
        return new ResponseEntity<> ( "hello world" , HttpStatus.OK );
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDto> post ( @Valid @RequestBody UserDto userDto ) {
        User user = userService.findByEmail ( userDto.getEmail () );
        if (user != null) {
            //return error;
            System.out.println ( "Email already in DB, please choose another" );
            return new ResponseEntity<> ( HttpStatus.UNPROCESSABLE_ENTITY );
        }

        UserDto userDtoResult = userService.addUser ( userDto );
        return new ResponseEntity<> ( userDtoResult , HttpStatus.OK );
    }
}
