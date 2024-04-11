package integration.user;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserApi extends ApiBase {

    Response response;
    @Step("Registration user")
    public String registration(String email, String password, String confirmPassword, String role, int expectedStatusCode) {
        String endPoint = "/api/auth/register";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);
        body.put("confirmPassword", confirmPassword);
        body.put("role", role);

        Response response = postRequest(endPoint, expectedStatusCode, body);
        int statusCode = response.statusCode();

        if (statusCode == expectedStatusCode) {
            return "User registered successfully";
        } else {
            String errorMessage = response.jsonPath().getString("message");
            return "Failed to register user: " + errorMessage;
        }
    }

    @Step("Вход через API: {email}")
    public String login(String email, String password, int expectedStatusCode) {
        String endpoint = "/api/auth/login";
        Map<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);

        Response response = postRequest(endpoint, expectedStatusCode, body);
        int code = response.statusCode();

        if (code == expectedStatusCode) {
            String refreshToken = response.jsonPath().getString("refreshToken");
            return "Токен обновления: " + refreshToken;
        } else {
            String errorMessage = response.getBody().asString();
            return "Не удалось войти: " + errorMessage;
        }
    }

    @Step("Активация нового пользователя: {refreshToken}")
    public String refreshToken(String refreshToken, int expectedStatusCode) {
        String endpoint = "/api/auth/refresh";
        Map<String, String> body = new HashMap<>();
        body.put("refreshToken", refreshToken);

        Response response = postRequest(endpoint, expectedStatusCode, body);
        return response.getBody().asString();
    }

    public static class UserApiTest {

        UserApi userApi;

        Faker faker = new Faker();

        @Test
        public void testNewUserRegistration() {
            String email = faker.internet().emailAddress();
            String password = "TestPassword123";
            String confirmPassword = "TestPassword123";
            String role = "user";

            userApi = new UserApi();


            userApi.registration(email, password, confirmPassword, role, 201);
            userApi.login(email,password,200);

        }
        @Test
        public void userCanRegistrationAsUser() {
            String email = faker.internet().emailAddress();
            String password = "Tatata123";
            String confirmPassword = "Tatata123";
            String role = "user";
            userApi = new UserApi();
            userApi.registration(email,password,confirmPassword,role,201);
        }

        }
}