package com.sda.auction.service.impl;

import com.sda.auction.dto.UserDto;
import com.sda.auction.mapper.UserMapper;
import com.sda.auction.model.User;
import com.sda.auction.repository.UserRepository;
import com.sda.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl ( UserMapper userMapper , UserRepository userRepository ) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }


    @Override
    public UserDto addUser ( UserDto userDTO ) {

        //convertim dto in entity
        User user = userMapper.convert ( userDTO );

        //persistam in baza de date
        User savedUser = userRepository.save ( user );

        //convertim entitatea persistata inapoi in dto
        return userMapper.convert ( savedUser );
    }
}
