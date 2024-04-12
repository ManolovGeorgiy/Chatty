package integration.pages.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.ApiBase;
import integration.schemas.PostCreateReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class CreatePost extends ApiBase {
    public CreatePost(String token) {
        super(token);
    }
    @Step("Create post")
    public String createPost(PostCreateReq postCreateReq, int expectedStatusCode) throws JsonProcessingException {
        String endpoint = "/api/posts";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody = objectMapper.writeValueAsString(postCreateReq);
        Response response = postRequest(endpoint,expectedStatusCode,jsonRequestBody);
        switch (response.getStatusCode()) {
            case 201:
                return  response.asString();
            case 400:
                return "Bad Request: " + response.jsonPath().getString("message");
            case 401:
                return "Unauthorized: " + response.jsonPath().getString("message");
            case 404:
                return "Not Found: " + response.jsonPath().getString("message");
            default:
                return "Unexpected status code: " + response.getStatusCode() + ". Response: " + response.asString();
        }
    }
}