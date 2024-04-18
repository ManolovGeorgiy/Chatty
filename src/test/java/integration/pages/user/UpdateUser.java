package integration.pages.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.ApiBase;
import integration.schemas.UserUpdateReq;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
<<<<<<< HEAD
import static org.testng.AssertJUnit.assertNotNull;

public class UpdateUser extends ApiBase {
=======

import static org.testng.AssertJUnit.assertNotNull;

public class UpdateUser extends ApiBase {

>>>>>>> origin/dev_Natalie
    public UpdateUser(String token) {
        super(token);
    }

    @Step("Update user with {id}")
<<<<<<< HEAD
    public String updateUser(String userId, UserUpdateReq userUpdateReq, int code) throws JsonProcessingException {
=======
    public String updateUserProfile(String userId, UserUpdateReq userUpdateReq, int code) throws JsonProcessingException {
>>>>>>> origin/dev_Natalie
        String endpoint = "/api/users/{id}";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(userUpdateReq);

<<<<<<< HEAD
        Response response = putRequest(endpoint,code,jsonRequest,"id",userId);

        if (response.getStatusCode() == 200) {
            JsonPath jsonPath = response.jsonPath();
            assertNotNull("ID is missing", jsonPath.get("id"));
=======
        Response response = putRequest(endpoint, code, jsonRequest, "id", userId);
        validateResponse(response);
        return handleResponse(response);
    }

    private void validateResponse(Response response) {
        if (response.getStatusCode() == 200) {
            JsonPath jsonPath = response.jsonPath();
            assertNotNull("Id is missing", jsonPath.get("id"));
>>>>>>> origin/dev_Natalie
            assertNotNull("Name is missing", jsonPath.get("name"));
            assertNotNull("Surname is missing", jsonPath.get("surname"));
            assertNotNull("Phone is missing", jsonPath.get("phone"));
            assertNotNull("Email is missing", jsonPath.get("email"));
            assertNotNull("Gender is missing", jsonPath.get("gender"));
            assertNotNull("AvatarUrl is missing", jsonPath.get("avatarUrl"));
        }
<<<<<<< HEAD
        switch (response.getStatusCode()) {
            case 200:
                return  response.asString();
=======
    }
    private String handleResponse(Response response) {
        switch (response.getStatusCode()) {
            case 200:
                return response.asString();
>>>>>>> origin/dev_Natalie
            case 400:
                return "Bad Request: " + response.jsonPath().getString("message");
            case 401:
                return "Unauthorized: " + response.jsonPath().getString("message");
            default:
                return "Unexpected status code: " + response.getStatusCode() + ". Message: " + response.asString();
        }
    }
}
<<<<<<< HEAD


=======
>>>>>>> origin/dev_Natalie
