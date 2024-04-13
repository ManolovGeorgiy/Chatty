package integration.pages.post;

import integration.ApiBase;
import io.restassured.response.Response;

public class DeletePost extends ApiBase {

    Response response;

    public DeletePost(String token) {
        super(token);
    }

    public String deleteUserPost(String postId, int code) {
        String endpoint = "/api/posts/{id}";
        response = deleteRequest(endpoint, code,postId);
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