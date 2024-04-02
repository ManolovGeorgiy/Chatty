package integration.user;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.LinkedHashMap;

public class AdminApi extends ApiBase {
    Response response;

    public AdminApi() {

    }

    @Step("User Login via api: {email},{password}")
    public Tokens userLogin(String email, String password, int code) {
        String endpoint = "/api/auth/login";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);
        response = postRequest(endpoint, code, body);

        // Проверяем успешность запроса
        if (response.getStatusCode() == 200) {
            String accessToken = response.jsonPath().getString("accessToken");
            String refreshToken = response.jsonPath().getString("refreshToken");
            long expiration = response.jsonPath().getLong("expiration");
            System.out.println("Access Token: " + accessToken);
            System.out.println("Refresh Token: " + refreshToken);
            System.out.println("Expiration: " + expiration);

        }
        return (Tokens) response;
    }

    @Step("New Admin Registration : {email},{password},{confirmPassword},{role}")
    public String newAdminRegistration(String email, String password, String confirmPassword, String role, int code) {
        String endpoint = "/api/auth/register";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);
        body.put("confirmPassword", confirmPassword);
        body.put("role", role);
        response = postRequest(endpoint, code, body);
        return response.asString();
    }

    @Step("Refresh Access Token via api: {refreshToken}")
    public String refreshAccessToken(String refreshToken, int code) {
        String endpoint = "/api/auth/refresh";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("refreshToken", refreshToken);
        response = postRequest(endpoint, code, body);
        return response.asString();
    }
}
