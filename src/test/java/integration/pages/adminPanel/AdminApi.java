package integration.pages.adminPanel;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.LinkedHashMap;

public class AdminApi extends ApiBase {
    Response response;

    @Step("Login by Email and Password : {email},{password}")
    public String loginAdmin(String email, String password, int code) {
        String endPoint = "/api/auth/login";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);

        response = postRequest(endPoint, code, body);
        int statusCode = response.statusCode();

        if (statusCode == code) {
            String refreshToken = response.jsonPath().getString("refreshToken");
            return refreshToken;
        } else {
            String errorMessage = response.jsonPath().getString("message");
            return "Failed to login: " + errorMessage;
        }
    }
}


