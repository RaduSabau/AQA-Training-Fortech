package bookstoreApi.bookstoreuserbuilder;

import lombok.Builder;

@Builder(setterPrefix = "with")
public class BookStoreIsbnUserBody {
    private String isbn;
    private String userId;
}
