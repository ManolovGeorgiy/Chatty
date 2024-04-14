package integration.tests.deleteuser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.Config;
import integration.pages.user.UserApi;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import util.UserInfoDto;

import java.util.List;
import java.util.Random;
import static org.testng.AssertJUnit.assertNotNull;

public class DeleteUser {
    private final Config config = new Config();
    protected final String BASE_URL = config.getProjectApiUrl();
    protected final RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .build();
    UserApi userApi;

    @Test
    public void userCanLogin() {
        String email = generateRandomEmail();
        String password = "Boba9876";
        String confirmPassword = "Boba9876";
        String role = "user";

        userApi = new UserApi();
        userApi.registration(email, password, confirmPassword, role, 201);

        String emailLogin = "Boba1234@mail.ru";
        String passwordLogin = "Boba1234";
        String deleteUserEndpoint = "/api/users";

        userApi = new UserApi();
        String token = userApi.login(emailLogin, passwordLogin, 200);

        UserInfoDto userInfo = getUserByEmail(token, email, 200).get(0);
        assertNotNull(userInfo);

        RestAssured.given()
                .spec(spec)
                .header("Authorization", "Bearer " + token)
                .when()
                .body(userInfo)
                .log().all()
                .delete(deleteUserEndpoint + "/" + userInfo.getId())
                .then().log().all()
                .extract().response();

        checkUserDelete(token, email, 404);

    }


    public List<UserInfoDto> getUserByEmail(String token, String email, int expectedStatusCode) {
        String endpoint = "/api/users";

        Response response = RestAssured.given()
                .spec(spec)
                .queryParam("email", email)
                .queryParam("limit", 10)
                .header("Authorization", "Bearer " + token)
                .when()
                .log().all()
                .get(endpoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();

        ObjectMapper objectMapper = new ObjectMapper();
        List<UserInfoDto> userInfoList = objectMapper.convertValue(response.jsonPath().getList(""), new TypeReference<List<UserInfoDto>>() {});

        return userInfoList;
    }

    public void checkUserDelete(String token, String email, int expectedStatusCode) {
        String endpoint = "/api/users";

        Response response = RestAssured.given()
                .spec(spec)
                .queryParam("email", email)
                .queryParam("limit", 10)
                .header("Authorization", "Bearer " + token)
                .when()
                .log().all()
                .get(endpoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();

    }


    public String generateRandomEmail() {
        String baseEmail = "example"; // Base email address
        String domain = "example.com"; // Domain name
        Random random = new Random();
        int randomNumber = random.nextInt(Integer.MAX_VALUE);

        // Concatenate the base email, random UUID, and domain
        String randomEmail = baseEmail + randomNumber + "@" + domain;
        ;

        return randomEmail;
    }
}
