package com.sda.auction.service;

import com.sda.auction.dto.LoginDto;
import com.sda.auction.dto.UserDto;
import com.sda.auction.model.User;
import org.springframework.stereotype.Service;


public interface UserService {
    UserDto addUser ( UserDto userDTO );

    User findByEmail ( String email );

    LoginDto login ( LoginDto loginDto );

}


