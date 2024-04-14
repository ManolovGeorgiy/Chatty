package integration.pages.adminPanel;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class AdminDeleteUser extends ApiBase {
    Response response;
    @Step("Delete user by admin: {userId}, {code}")
    public String deleteUser(String userId, int code) {
        String endPoint = "/api/admin/deleteUser/{userId}";

        response = deleteRequest(endPoint, code, userId);
        int statusCode = response.statusCode();

        if (statusCode == code) {
            return "User deleted successfully by admin";
        } else {
            String errorMessage = response.jsonPath().getString("message");
            return "Failed to delete user by admin: " + errorMessage;
        }
    }
}
