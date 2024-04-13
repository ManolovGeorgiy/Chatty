package integration.pages.post;

import integration.ApiBase;
import io.restassured.response.Response;

public class GetPostByPostId extends ApiBase {
    public GetPostByPostId(String token){
        super(token);
    }
    Response response;
    public String getPostId(String postId,int code){
        String endPoint = "/api/posts/{id}";
        response = getRequestWhitParam(endPoint,code,"id",postId);
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
