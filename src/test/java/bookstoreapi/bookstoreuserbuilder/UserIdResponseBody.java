package bookstoreapi.bookstoreuserbuilder;

import lombok.Data;

@Data
public class UserIdResponseBody {
    private String userId;
    private String username;
    private Book books;
}
