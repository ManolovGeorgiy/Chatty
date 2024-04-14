package integration.pages.adminPanel;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.LinkedHashMap;

public class AdminEditUser extends ApiBase {
    Response response;
    @Step("Edit user by admin: {userId}, {email}, {password}, {role}, {code}")
    public String editUser(String userId, String email, String password, String role, int code) {
        String endPoint = "/api/admin/editUser/{userId}";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);
        body.put("role", role);

        response = putRequest(endPoint, code, body, "userId", userId);
        int statusCode = response.statusCode();

        if (statusCode == code) {
            return "User edited successfully by admin";
        } else {
            String errorMessage = response.jsonPath().getString("message");
            return "Failed to edit user by admin: " + errorMessage;
        }
    }
}
