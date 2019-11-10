package com.sda.auction.validator;

import com.sda.auction.dto.UserDto;
import com.sda.auction.model.User;
import com.sda.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserDtoValidator {

    @Autowired
    private UserService userService;

    public boolean validate( UserDto userDto ){
        if (passwordsDontMarch (userDto)){
            throw new RuntimeException ( "Passwords do not match!" );
//            return new ResponseEntity<> ( HttpStatus.NOT_ACCEPTABLE );
        }

        if (emailAlreadyRegistered(userDto.getEmail ())) {
            //return error;
//            return new ResponseEntity<> ( HttpStatus.UNPROCESSABLE_ENTITY );
            throw new RuntimeException ( "Email already registered" );
        }
        return true;
    }

    private boolean passwordsDontMarch( UserDto userDto ) {
        return userDto.getPassword ().compareTo ( userDto.getConfirmPassword () ) != 0;
    }

    private boolean emailAlreadyRegistered ( String email ) {
        User user = userService.findByEmail ( email );
        return user != null;
    }
}
