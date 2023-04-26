package bookstoreApi.bookstoreuserbuilder;

import bookstoreApi.AccountAPI;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.Utils;

public class BookStoreJsonBodyBuilders {
    Gson gson = new Gson();

    public Book[] getListOfBooks(String endpoint) {
        new AccountAPI().setRestAssured();
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
}
