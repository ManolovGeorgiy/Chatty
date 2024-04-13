package integration.pages.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import integration.ApiBase;
import integration.schemas.PostCreateReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class CreatePost extends ApiBase {

    public CreatePost(String token) {
        super(token);
    }

    Response response;
    Faker faker = new Faker();
    PostCreateReq postCreateReq;
    String title = "er";
    String description = "er";
    String body = faker.lorem().sentence(50);
    String publishDate = "";
    String imageUrl = "https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg";

    public PostCreateReq createUserPostForm (String postCreateReq){
        this.postCreateReq = new PostCreateReq();
        this.postCreateReq.setTitle(title);
        this.postCreateReq.setDescription(description);
        this.postCreateReq.setBody(body);
        this.postCreateReq.setPublishDate(publishDate);
        this.postCreateReq.setImageUrl(imageUrl);

        return this.postCreateReq;
    }
    public Response createAPostRoleUser(int code,String postCreateReq) {
        String endpoint = "/api/posts";
        Object body = createUserPostForm(postCreateReq);
        response = postRequest(endpoint, code, body);
        return response;
    }
    @Step("Create post")
    public String createPost(int code,PostCreateReq postCreateReg) throws JsonProcessingException {
        String endpoint = "/api/posts";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody = objectMapper.writeValueAsString(postCreateReg);
        response = postRequest(endpoint,code,jsonRequestBody);
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