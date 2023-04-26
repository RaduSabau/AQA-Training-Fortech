package tests.backendtests;

import bookstoreApi.AccountAPI;
import bookstoreApi.bookstoreuserbuilder.BookStoreJsonBodyBuilders;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class AccountAPITest {
    AccountAPI accountAPI = new AccountAPI();
    BookStoreJsonBodyBuilders bookStoreJsonBodyBuilders = new BookStoreJsonBodyBuilders();

    @Test
    public void testCreateAndDeleteUser() {
        String body = bookStoreJsonBodyBuilders.bookStoreUserJson();
        Response response = accountAPI.postResponse(accountAPI.userEndpoint, body);
        String userId = response.getBody().jsonPath().get("userID");
        String token = accountAPI.postResponse(accountAPI.generateTokenEndpoint, body).getBody().jsonPath().get("token");
        accountAPI.postResponse(accountAPI.authorizedEndpoint, body);
        accountAPI.getResponseWithUserId(accountAPI.userIdEndpoint,token,userId);
        accountAPI.deleteResponseWithUserId(accountAPI.userIdEndpoint, userId, token);
    }
}
