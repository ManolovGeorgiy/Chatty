package integration.pages.adminPanel;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class AdminCreateUser extends ApiBase {
    Response response;

    @Step("Create user by admin: {email}, {password}, {role}, {code}")
    public String createUser(String email, String password, String role, int code) {
        String endPoint = "/api/admin/createUser";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);
        body.put("role", role);

        response = postRequest(endPoint, code, body);
        int statusCode = response.statusCode();

        if (statusCode == code) {
            return "User created successfully by admin";
        } else {
            String errorMessage = response.jsonPath().getString("message");
            return "Failed to create user by admin: " + errorMessage;
        }
    }
}
