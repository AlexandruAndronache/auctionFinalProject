package com.sda.auction.mapper;

import com.sda.auction.dto.UserDto;
import com.sda.auction.model.User;

public class UserMapper {
    public User convert ( UserDto userDTO ) {
        User user = new User ();
        user.setFirstName ( userDTO.getFirstName () );
        user.setLastName ( userDTO.getLastName () );
        user.setEmail ( userDTO.getEmail () );
        user.setPassword ( userDTO.getPassword () );
        return user;

//        User user = User.builder().email(userDTO.getEmail ()).password(userDTO.getPassword ()).firstName(userDTO.getFirstName ())
    }
}
