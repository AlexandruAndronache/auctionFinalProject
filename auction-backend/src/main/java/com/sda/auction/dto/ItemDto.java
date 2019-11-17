package com.sda.auction.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.*;

@Data
@EqualsAndHashCode
public class UserDto {

    private Integer id;

    @NotNull
    @NotEmpty(message = "Please insert your first name")
    @Pattern(regexp = "[A-Za-z]+", message = "Letters only")
    private String firstName;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-Za-z]+", message = "Letters only")
    private String lastName;


    @Email(message = "{error.user.email.pattern}")
    private String email;

    @NotEmpty
    @Pattern(regexp = "((.*)[A-Z]+(.*))", message = "Password should contain at least one capital letter!")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotEmpty
    @Pattern(regexp = "((.*)[A-Z]+(.*))", message = "Password should contain at least one capital letter!")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String confirmPassword;


}
