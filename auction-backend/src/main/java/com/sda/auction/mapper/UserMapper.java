package com.sda.auction.mapper;

import com.sda.auction.dto.UserDto;
import com.sda.auction.model.User;
import org.springframework.stereotype.Service;

@Service
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

    public UserDto convert ( User user ) {
        UserDto userDto = new UserDto ();
        userDto.setEmail ( user.getEmail () );
        userDto.setPassword ( user.getPassword () );
        userDto.setFirstName ( user.getFirstName () );
        userDto.setLastName ( user.getLastName () );
        user.setId ( user.getId () );
        return userDto;
    }
}
