package bookstoreApi.bookstoreuserbuilder;

import lombok.Builder;

@Builder(setterPrefix = "with")
public class BookStoreUser {
    private String userName;
    private String password;
}
