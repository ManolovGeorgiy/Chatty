package integration.user;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UserApi extends ApiBase {

    @Step("Регистрация нового пользователя: {email}, {role}")
    public String newUserRegistration(String email, String password, String confirmPassword, String role, int expectedStatusCode) {
        String endpoint = "/api/auth/register";
        Map<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);
        body.put("confirmPassword", confirmPassword);
        body.put("role", role);

        Response response = postRequest(endpoint, expectedStatusCode, body);
        int code = response.statusCode();

        if (code == expectedStatusCode) {
            return "Пользователь успешно зарегистрирован";
        } else {
            String errorMessage = response.getBody().asString();
            return "Не удалось зарегистрировать пользователя: " + errorMessage;
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

    @Step("Получение пользователя")
    public Response getUser(String token) {
        String endpoint = "/api/me";
        return getRequestWithParamString(endpoint, 200, "token", token);
    }
}
