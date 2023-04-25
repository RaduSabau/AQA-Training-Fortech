package tests.backendtests;

import bookstoreApi.AccountAPI;
import bookstoreApi.BookStoreAPI;
import bookstoreApi.bookstoreuserbuilder.Book;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;

public class BookStoreAPITest {
    private final String bookStoreEndpoint = "/BookStore/v1/";
    public String bookEndpoint = bookStoreEndpoint + "Book";
    public String booksEndpoint = bookStoreEndpoint + "Books";
    public String isbnBookEndpoint = bookStoreEndpoint + "{ISBN}";
    AccountAPI accountAPI = new AccountAPI();
    BookStoreAPI bookStoreAPI = new BookStoreAPI();
    Book[] books;

    @Test
    public void testAddDeleteUpdateBooksInList() {
        String body = accountAPI.bookStoreUserJson();
        Response response = accountAPI.postResponse(accountAPI.userEndpoint, body);
        String userId = response.getBody().jsonPath().get("userID");
        String token = accountAPI.postResponse(accountAPI.generateTokenEndpoint, body).getBody().jsonPath().get("token");
        accountAPI.postResponse(accountAPI.authorizedEndpoint, body);
        books = bookStoreAPI.getListOfBooks(booksEndpoint);
        for (int i=0;i<4;i++){
                    bookStoreAPI.postAddListOfBooks(booksEndpoint,token,userId,books[i].getIsbn());
        }
        accountAPI.getResponseWithUserId(accountAPI.userIdEndpoint,userId,token);
        accountAPI.deleteResponseWithUserId(accountAPI.userIdEndpoint, userId, token);
    }
}
