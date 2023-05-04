package tests.backendtests;

import bookstoreapi.AccountAPI;
import bookstoreapi.BookStoreAPI;
import bookstoreapi.bookstoreuserbuilder.Book;
import bookstoreapi.bookstoreuserbuilder.BookStoreJsonBodyBuilders;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static bookstoreapi.AccountAPI.userBooksIsbnList;

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
            bookStoreAPI.getBookByIsbn(bookEndpoint, token, books[i].getIsbn());
            bookStoreAPI.postAddListOfBooks(booksEndpoint, token, userId, books[i].getIsbn());
        }
        accountAPI.getBooksIsbnWithUserId(accountAPI.userIdEndpoint, userId, token);
        bookStoreAPI.deleteBook(bookEndpoint, token, userId, userBooksIsbnList.get(0).toString());
        accountAPI.getBooksIsbnWithUserId(accountAPI.userIdEndpoint, userId, token);
        bookStoreAPI.putResponseForBook(isbnBookEndpoint, token, userId, books[5].getIsbn(), userBooksIsbnList.get(0).toString());
        bookStoreAPI.deleteAllBooks(booksEndpoint, token, userId);
        accountAPI.getBooksIsbnWithUserId(accountAPI.userIdEndpoint, userId, token);
        accountAPI.deleteResponseWithUserId(accountAPI.userIdEndpoint, userId, token);
    }
}
