package com.saucedemo.dto.userbuilderjson;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder(setterPrefix = "with")
public class Users {
    private Collection<User> users;
}
