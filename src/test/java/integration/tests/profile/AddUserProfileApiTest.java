package integration.tests.profile;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import integration.pages.profile.ProfileApi;
import integration.pages.profile.UpdateProfile;
import integration.pages.user.UserApi;
import integration.schemas.PostCreateReq;
import integration.schemas.PostUpdateReq;
import integration.schemas.UserUpdateReq;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class AddUserProfileApiTest  {
    Faker faker = new Faker();
    UserApi userApi;
    ProfileApi profileApi;

    GetProfileByProfileId getProfileByProfileId;

    UpdateProfile updateProfile;

    //DeleteProfile deleteProfile;

    private void checkProfileData(String profileId, UserUpdateReq userUpdateReq){

        //JsonPath actualObjects = JsonPath.given(getPostByPostId.getPostId(postId,200));
        //JsonPath actualObjects;
        //Object profileId = null;
//
        //actualObjects = JsonPath.given(getProfileByProfileId.getProfileId(null,200));
        JsonPath actualObjects = JsonPath.given(getProfileByProfileId.getProfileId(null,200));
        LinkedHashMap<String,String> profileObjects = new LinkedHashMap<>();
        profileObjects.put(actualObjects.getString("name"),userUpdateReq.getName());
        profileObjects.put(actualObjects.getString("surname"),userUpdateReq.getSurname());
        profileObjects.put(actualObjects.getString("birthDate"),userUpdateReq.getBirthDate());
        profileObjects.put(actualObjects.getString("phone"),userUpdateReq.getPhone());
        profileObjects.put(actualObjects.getString("gender"),userUpdateReq.getGender());
        profileObjects.put(actualObjects.getString("backgroundUrl"),userUpdateReq.getBackgroundUrl());
        profileObjects.put(actualObjects.getString("blocked"),userUpdateReq.toString());//вопрос,,.
        //postObjects.put(actualObjects.getString("birthDate"),userUpdateReq.getBirthDate());

        for (Map.Entry<String,String> profileObject:profileObjects.entrySet()){
            String actualResult = profileObject.getKey();
            String expectedResult =profileObject.getValue();
            Assert.assertEquals(actualResult,expectedResult, actualResult + " is not equals " + expectedResult);
        }
    }
    @Feature(value = "Creating profile")
    @Story(value = "User can create a profile")
    @Description(value = "User can create a profile")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can create profile")
    public void userCanCreateProfile() throws JsonProcessingException {
        String email = "jelly.b@gmail.com";
        String password = "doggy888";

        String name = "Bob";
        String surname= "Bobby";
        String birthDate = "05-06-1999";
        //String imageURL = ("https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-1080x675.jpg");
        String phone = "+38099483284";
        String gender = "Female";


        String editName = "Gleb";
        String editSurname = "Glebby";
        String editBirthDate = "07-07-2000";
        String editPhone = "+37745868789";
        String editedGender = "male";
        //String editImageURL = ("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");


        userApi = new UserApi();
        String token = userApi.login(email, password, 200);

        UserUpdateReq userUpdateReq = new UserUpdateReq();
        userUpdateReq.setName(name);
        userUpdateReq.setSurname(surname);
        userUpdateReq.setBirthDate(birthDate);
        userUpdateReq.setPhone(phone);
        userUpdateReq.setGender(gender);

        profileApi = new ProfileApi(token);
        String response = profileApi.createProfile(200,userUpdateReq);
        JsonPath jsonPath = new JsonPath(response);
        String profileId = jsonPath.getString("id");

        getProfileByProfileId = new GetProfileByProfileId(token);
        checkProfileData(profileId,userUpdateReq);



       //PostUpdateReq postUpdateReq = new PostUpdateReq();
       //postUpdateReq.setTitle(editTitle);
       //postUpdateReq.setDescription(editDescription);
       //postUpdateReq.setBody(editBody);
       //postUpdateReq.setImageUrl(editImageURL);

       //updatePost = new UpdatePost(token);
       //String responseEdit = updatePost.updateUserPost(postId, postUpdateReq, 200);
       //JsonPath jsonPathEdit = new JsonPath(responseEdit);
       //String editPostId = jsonPathEdit.getString("id");

       //deletePost = new DeletePost(token);
       //deletePost.deleteUserPost(editPostId, 204);
    }
}

