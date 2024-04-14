package integration.tests.profile;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import integration.ApiBase;
import integration.schemas.PostCreateReq;
import integration.schemas.UserUpdateReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class AddUserProfileApiTest extends ApiBase {
    public void CreateProfile(String token) {
        super(token);

    }

    Response response;
    Faker faker = new Faker();
    UserUpdateReq userUpdateReq;
    String name = "er";
    String surname = "er";
    String birthDate = "" ;
    String phone = "";
    String gender = "";
    String backgroundUrl = "";
    String blocked = "";

    //String imageUrl = "https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg";

    public UserUpdateReq createUserProfileForm (String userUpdateReq){
        this.userUpdateReq = new UserUpdateReq();
        this.userUpdateReq.setName(name);
        this.userUpdateReq.setSurname(surname);
        this.userUpdateReq.setBirthDate(birthDate);
        this.userUpdateReq.setPhone(phone);
        this.userUpdateReq.setGender(gender);
        this.userUpdateReq.setBackgroundUrl(backgroundUrl);
        this.userUpdateReq.setBlocked(Boolean.parseBoolean(blocked));

        return this.userUpdateReq;
    }
    public Response createAUserUpdateReq(int code,String postCreateReq) {
        String endpoint = "/api/users/{id}";
        Object body = createUserProfileForm(String.valueOf(userUpdateReq));
        response = postRequest(endpoint, code, body);
        return response;
    }
    @Step("Create profile")
    public String createProfile(int code,UserUpdateReq userUpdateReq) throws JsonProcessingException {
        String endpoint = "/api/users/{id}";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody = objectMapper.writeValueAsString(userUpdateReq);
        response = postRequest(endpoint,code,jsonRequestBody);
        switch (response.getStatusCode()) {
            case 200:
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
