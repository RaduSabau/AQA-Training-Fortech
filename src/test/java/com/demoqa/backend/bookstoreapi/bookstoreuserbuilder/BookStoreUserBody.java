package com.demoqa.backend.bookstoreapi.bookstoreuserbuilder;

import lombok.Builder;

@Builder(setterPrefix = "with")
public class BookStoreUserBody {
    private String userName;
    private String password;
}
