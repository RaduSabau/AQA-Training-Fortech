package com.demoqa.backend.bookstoreapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

public class AccountAPI {
    public static ArrayList userBooksIsbnList;
    private final String accountEndpoint = "/Account/v1/";
    public final String userEndpoint = accountEndpoint + "User";
    public String userIdEndpoint = userEndpoint + "/{userID}";
    public String generateTokenEndpoint = accountEndpoint + "GenerateToken";
    public String authorizedEndpoint = accountEndpoint + "Authorized";

    public void setRestAssured() {
        RestAssured.baseURI = "https://demoqa.com";
    }

    public Response postResponse(String endPoint, String value) {
        setRestAssured();
        RequestSpecification request = RestAssured.given().body(value).log().uri();
        RestAssured.defaultParser = Parser.JSON;
        return request.contentType(ContentType.JSON).when().post(endPoint).then().log().status().log().body().extract().response();
    }

    public void deleteResponseWithUserId(String endpoint, String userId, String token) {
        setRestAssured();
        RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).header("Authorization", token).pathParam("userID", userId).log().uri();
        request.when().delete(endpoint).then().log().status().log().body();
    }

    public void getBooksIsbnWithUserId(String endpoint, String userId, String token) {
        setRestAssured();
        RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).header("Authorization", token).pathParam("userID", userId).log().uri();
        userBooksIsbnList = request.when().get(endpoint).then().log().status().log().body().extract().path("books.isbn");
    }
}
