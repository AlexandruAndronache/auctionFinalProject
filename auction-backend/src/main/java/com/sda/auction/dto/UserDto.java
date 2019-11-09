package com.sda.auction.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode
public class UserDto {

    @NotNull
    @NotEmpty(message = "Please insert your first name")
    @Pattern ( regexp = "[A-Za-z]+", message = "Letters only")
    private String firstName;

    @NotNull
    @NotEmpty
    @Pattern ( regexp = "[A-Za-z]+", message = "Letters only")
    private String lastName;


    @Email(message = "({error.user.email.pattern})")
    private String email;

    @Pattern ( regexp = "^(?=.*\\d).{6}$", message = "Letters,numbers and min 6 chars")
    private String password;


}
