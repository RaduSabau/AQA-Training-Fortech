package com.saucedemo.dto;

import java.util.*;

public class UsersBuilder {
    public Users userGenerator() {
        List<User> usersList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String password = "secret_sauce";
            usersList.add(User.builder().withUsername(userMap("username").get(i))
                    .withPassword(password)
                    .withFirstName(userMap("firstname").get(i))
                    .withLastName(userMap("lastname").get(i))
                    .withPostalCode(userMap("postalCode").get(i)).build());
        }
       return Users.builder().withUsers(usersList).build();
    }

    private List<String> userMap(String key) {
        Map<String, List<String>> map = new HashMap<>() {{
            put("username", Arrays.asList("standard_user", "locked_out_user", "problem_user", "performance_glitch_user"));
            put("firstname",Arrays.asList("Doe","Smith","Peterson","Jackson"));
            put("lastname", Arrays.asList("John","Jane","George","Julian"));
            put("postalCode",Arrays.asList("400400","100100","200200","300300"));
        }};
        return map.get(key);
    }
}
