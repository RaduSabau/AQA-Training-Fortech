package com.saucedemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String postalCode;
}
