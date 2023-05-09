package com.saucedemo.dto.userbuilderjson;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class User {
    private String username;
    private String password;
}
