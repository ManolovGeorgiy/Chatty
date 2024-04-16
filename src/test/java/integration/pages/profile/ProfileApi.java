package integration.pages.profile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import integration.ApiBase;
import integration.schemas.UserUpdateReq;
import io.restassured.response.Response;
import org.openqa.selenium.devtools.v117.accessibility.model.AXValueType;

import static java.util.Objects.requireNonNull;

public class ProfileApi  extends ApiBase {


    public ProfileApi(AXValueType token, AXValueType axValueType) {
        super(String.valueOf(token));
    }


    Response response;
    Faker faker = new Faker();
    UserUpdateReq userUpdateReq;
    String name = "er";
    String surname = "er";
    String birthDate = "";
    String phone = "";
    String gender = "";
    String backgroundUrl = "";
    String blocked = "";

    public ProfileApi(String token) {

    }

    //String imageUrl = "https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg";

    public UserUpdateReq createUserProfileForm(String userUpdateReq) {
       // this.userUpdateReq = new UserUpdateReq();
        this.userUpdateReq.setName(name);
        this.userUpdateReq.setSurname(surname);
        this.userUpdateReq.setBirthDate(birthDate);
        this.userUpdateReq.setPhone(phone);
        this.userUpdateReq.setGender(gender);
        this.userUpdateReq.setBackgroundUrl(backgroundUrl);
        this.userUpdateReq.setBlocked(Boolean.parseBoolean(blocked));

        return this.userUpdateReq;
    }
    //public Response createUserUpdateReq(int code,String userUpdateReq) {
    //    String endpoint = "/api/users/{id}";
    //    Object body = createUserProfileForm(String.valueOf(userUpdateReq));
    //    response = postRequest(endpoint, code, body);
    //    return response;
    //}
    //public Response createProfile(Map<String, Object> profileData) {
    //    return postRequest("profile", 201, profileData);
    //}
    //@Step("Create profile")
    //public String createProfile(int code, UserUpdateReq userUpdateReq) throws JsonProcessingException {
    //    String endpoint = "/api/users/{id}";
    //    ObjectMapper objectMapper = new ObjectMapper();
    //    String jsonRequestBody = objectMapper.writeValueAsString(userUpdateReq);
    //    response = profileRequest(endpoint,code,jsonRequestBody);
    //    switch (requireNonNull(response).getStatusCode()) {
    //        case 200:
    //            return  response.asString();
    //        case 400:
    //            return "Bad Request: " + response.jsonPath().getString("message");
    //        case 401:
    //            return "Unauthorized: " + response.jsonPath().getString("message");

    //        default:
    //            return "Unexpected status code: " + response.getStatusCode() + ". Response: " + response.asString();
    //    }
    //}

   private Response profileRequest(String endpoint, int code, String jsonRequestBody) {
       return null;
   }

    public String createProfile(int expectedStatusCode, UserUpdateReq userUpdateReq) throws JsonProcessingException {
        String endpoint = "/api/users/{id}";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody = objectMapper.writeValueAsString(userUpdateReq);

        Response response = profileRequest(endpoint, expectedStatusCode, jsonRequestBody);

        if (response != null) {
            int statusCode = response.getStatusCode();
            switch (statusCode) {
                case 200:
                    return response.asString();
                case 400:
                    return "Bad Request: " + response.jsonPath().getString("message");
                case 401:
                    return "Unauthorized: " + response.jsonPath().getString("message");
                default:
                    return "Unexpected status code: " + statusCode + ". Response: " + response.asString();
            }
        } else {
            return "Response is null";
        }
    }

    public String getpofileId(String profileId, int i) {

        return profileId;
    }
}
