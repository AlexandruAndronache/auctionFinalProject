package com.sda.auction.service;

import com.sda.auction.dto.UserDto;
import com.sda.auction.model.User;

public interface UserService {
    UserDto addUser( UserDto userDTO);

    User findByEmail ( String email );
}


