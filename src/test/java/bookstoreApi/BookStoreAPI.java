package bookstoreApi;

import bookstoreApi.bookstoreuserbuilder.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BookStoreAPI {
    AccountAPI accountAPI = new AccountAPI();

    public Book[] getListOfBooks(String endpoint) {
        accountAPI.setRestAssured();
        RequestSpecification request = RestAssured.given().log().uri();
        return request.contentType(ContentType.JSON).when()
                .get(endpoint).then().log().status().extract().response().jsonPath().getObject("books",Book[].class);
    }

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
}
