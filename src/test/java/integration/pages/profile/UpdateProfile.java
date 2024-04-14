package integration.pages.profile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.ApiBase;
import integration.schemas.PostUpdateReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class UpdateProfile extends ApiBase {

    public UpdateProfile(String token) {
        super(token);
    }

    Response response;

    @Step("Update profile {id}")
    public String updateUserProfile(String postId, UpdateProfile postUpdateReq, int code) throws JsonProcessingException {
        String endpoint = "/api/users/{id}";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody = objectMapper.writeValueAsString(postUpdateReq);
        response = putRequest(endpoint, code, jsonRequestBody, "id", null);
        switch (response.getStatusCode()) {
            case 200:
                return response.asString();
            case 400:
                return "Bad Request: " + response.jsonPath().getString("message");
            case 401:
                return "Unauthorized: " + response.jsonPath().getString("message");
            default:
                return "Unexpected status code: " + response.getStatusCode() + " - " + response.asString();
        }
    }

    private Response putRequest(String endpoint, int code, String jsonRequestBody, String id, String profileId) {
        return null;
    }
}






