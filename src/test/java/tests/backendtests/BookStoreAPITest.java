package tests.backendtests;

import bookstoreApi.AccountAPI;
import bookstoreApi.BookStoreAPI;
import bookstoreApi.bookstoreuserbuilder.Book;
import bookstoreApi.bookstoreuserbuilder.BookStoreJsonBodyBuilders;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class BookStoreAPITest {
    private final String bookStoreEndpoint = "/BookStore/v1/";
    public String bookEndpoint = bookStoreEndpoint + "Book";
    public String booksEndpoint = bookStoreEndpoint + "Books";
    public String isbnBookEndpoint = bookStoreEndpoint + "{ISBN}";
    AccountAPI accountAPI = new AccountAPI();
    BookStoreAPI bookStoreAPI = new BookStoreAPI();
    BookStoreJsonBodyBuilders bookStoreJsonBodyBuilders = new BookStoreJsonBodyBuilders();
    Book[] books;

    @Test
    public void testAddDeleteUpdateBooksInList() {
        String body = bookStoreJsonBodyBuilders.bookStoreUserJson();
        Response response = accountAPI.postResponse(accountAPI.userEndpoint, body);
        String userId = response.getBody().jsonPath().get("userID");
        String token = accountAPI.postResponse(accountAPI.generateTokenEndpoint, body).getBody().jsonPath().get("token");
        accountAPI.postResponse(accountAPI.authorizedEndpoint, body);
        books = bookStoreJsonBodyBuilders.getListOfBooks(booksEndpoint);
        for (int i = 0; i < 4; i++) {
            bookStoreAPI.getBookByIsbn(bookEndpoint,token,books[i].getIsbn());
            bookStoreAPI.postAddListOfBooks(booksEndpoint, token, userId, books[i].getIsbn());
            bookStoreAPI.deleteBook(bookEndpoint,token,userId,books[i].getIsbn());
        }
//        bookStoreAPI.putResponseForBook(isbnBookEndpoint,token,userId);
        bookStoreAPI.deleteAllBooks(booksEndpoint,token,userId);
        accountAPI.getResponseWithUserId(accountAPI.userIdEndpoint, userId, token);
        accountAPI.deleteResponseWithUserId(accountAPI.userIdEndpoint, userId, token);
    }
    //TODO Error handling, project structuring
}
