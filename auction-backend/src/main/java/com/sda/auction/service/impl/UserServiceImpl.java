package com.sda.auction.service.impl;

import com.sda.auction.dto.UserDto;
import com.sda.auction.mapper.UserMapper;
import com.sda.auction.model.User;
import com.sda.auction.repository.UserRepository;
import com.sda.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private UserRepository userRepository;


    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl (
            UserMapper userMapper , UserRepository userRepository ,
            BCryptPasswordEncoder passwordEncoder
    ) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //this method is kept at same abstract level for the purpose of clean coding
    @Override
    public UserDto addUser ( UserDto userDTO ) {

        //convertim dto in entity
        User user = userMapper.convert ( userDTO );

        encodePassword ( user );

        //persistam in baza de date
        User savedUser = userRepository.save ( user );

        //convertim entitatea persistata inapoi in dto
        return userMapper.convert ( savedUser );
    }

    @Override
    public User findByEmail ( String email ) {
        return userRepository.findByEmail(email);
    }

    //created this class to preserve the level of abstraction
    private void encodePassword ( User user ) {
        //encode user's password and put it in passwordEncoded variable
        String passwordencoded = passwordEncoder.encode ( user.getPassword () );
        //set encoded password to user entity
        user.setPassword ( passwordencoded );
    }
}
