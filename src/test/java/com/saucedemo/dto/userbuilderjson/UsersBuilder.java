package com.saucedemo.dto.userbuilderjson;

import java.util.*;

public class UsersBuilder {
    public Users userGenerator() {
        List<User> usersList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String password = "secret_sauce";
            usersList.add(User.builder().withUsername(userMap("username").get(i)).withPassword(password).build());
        }
       return Users.builder().withUsers(usersList).build();
    }

    private List<String> userMap(String key) {
        Map<String, List<String>> map = new HashMap<>() {{
            put("username", Arrays.asList("standard_user", "locked_out_user", "problem_user", "performance_glitch_user"));
        }};
        return map.get(key);
    }
}
