package com.demoqa.backend.bookstoreapi;

import com.demoqa.backend.bookstoreapi.bookstoreuserbuilder.BookStoreJsonBodyBuilders;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BookStoreAPI {
    AccountAPI accountAPI = new AccountAPI();
    BookStoreJsonBodyBuilders bookStoreJsonBodyBuilders = new BookStoreJsonBodyBuilders();

    public void postAddListOfBooks(String endpoint, String token, String userID, String isbn) {
        accountAPI.setRestAssured();
        String userIdBody = """
                  {
                  "userId": "%s",
                  "collectionOfIsbns": [
                    {
                      "isbn": "%s"
                    }
                  ]
                }
                """.formatted(userID, isbn);
        RequestSpecification request = RestAssured.given().header("Authorization", token).contentType(ContentType.JSON).body(userIdBody).log().uri();
        request.when().post(endpoint).then().log().status().log().body();
    }

    public void getBookByIsbn(String endpoint,String token ,String isbn){
        accountAPI.setRestAssured();
        RequestSpecification request = RestAssured.given().header("Authorization", token).contentType(ContentType.JSON).queryParam("ISBN",isbn).log().uri();
        request.when().get(endpoint).then().log().status().log().body();
    }

    public void deleteBook(String endpoint, String token, String userId, String isbn){
        String isbnBody = bookStoreJsonBodyBuilders.bookStoreIsbnJson(userId,isbn);
        accountAPI.setRestAssured();
        RequestSpecification request = RestAssured.given().header("Authorization", token).contentType(ContentType.JSON).body(isbnBody).log().uri();
        request.when().delete(endpoint).then().log().status().log().body();
    }

    public void deleteAllBooks(String endpoint,String token, String userId){
        accountAPI.setRestAssured();
        RequestSpecification request = RestAssured.given().header("Authorization",token).contentType(ContentType.JSON).queryParam("UserId",userId).log().uri();
        request.when().delete(endpoint).then().log().status().log().body();
    }

    public void putResponseForBook(String endpoint, String token,String userId,String newIsbn, String isbnToBeReplaced){
        String isbnBody = bookStoreJsonBodyBuilders.bookStoreIsbnJson(userId,newIsbn);
        accountAPI.setRestAssured();
        RequestSpecification request = RestAssured.given().header("Authorization",token).contentType(ContentType.JSON).pathParam("ISBN",isbnToBeReplaced).body(isbnBody).log().uri();
        request.when().put(endpoint).then().log().status().log().body();
    }
}
