package integration.pages.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.ApiBase;
import integration.schemas.PostUpdateReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class UpdatePost extends ApiBase {
    public UpdatePost(String token) {
        super(token);
    }

    Response response;

    @Step("Update post {id}")
    public String updateUserPost(String postId, PostUpdateReq postUpdateReq, int code) throws JsonProcessingException {
        String endpoint = "/api/posts/{id}";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody = objectMapper.writeValueAsString(postUpdateReq);
        response = putRequest(endpoint, code, jsonRequestBody,"id",postId);
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
}
