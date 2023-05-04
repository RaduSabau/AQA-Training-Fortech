package bookstoreapi.bookstoreuserbuilder;

import bookstoreapi.AccountAPI;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.Utils;

public class BookStoreJsonBodyBuilders {
    Gson gson = new Gson();
    AccountAPI accountAPI = new AccountAPI();

    public Book[] getListOfBooks(String endpoint) {
        accountAPI.setRestAssured();
        RequestSpecification request = RestAssured.given().log().uri();
        return request.contentType(ContentType.JSON).when()
                .get(endpoint).then().log().status().extract().response().jsonPath().getObject("books",Book[].class);
    }

    public String bookStoreUserJson() {
        BookStoreUserBody user = BookStoreUserBody.builder().withUserName(new Utils().getRandomName().name())
                .withPassword("1234ASdf!@#$").build();
        return gson.toJson(user);
    }

    public String bookStoreIsbnJson(String userId,String isbn){
        BookStoreIsbnUserBody userIsbn = BookStoreIsbnUserBody.builder().withUserId(userId).withIsbn(isbn).build();
        return gson.toJson(userIsbn);
    }

    public UserIdResponseBody getListOfBooksFromUserJson(String endpoint,String userId){
        accountAPI.setRestAssured();
        RequestSpecification request = RestAssured.given().log().uri();
        return request.contentType(ContentType.JSON).pathParam("userID",userId)
                .when().get(endpoint)
                .then().log().status().extract().response().jsonPath().getObject("",UserIdResponseBody.class);
    }
}
