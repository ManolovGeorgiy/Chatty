package integration.tests.profile;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import integration.pages.profile.ProfileApi;
import integration.pages.user.UserApi;
import integration.schemas.UserRes;
import integration.schemas.UserUpdateReq;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class AddUserProfileApiTest {

    Faker faker = new Faker();
    UserApi userApi;
    ProfileApi profileApi;
    UserUpdateReq userUpdateReq;
    UserRes userRes;
    //DeleteUserProfile deleteUserProfile;


    private void checkProfileData(String profileId, UserUpdateReq userUpdateReq){

        JsonPath actualObjects = JsonPath.given(profileApi.getpofileId(profileId,200));
        LinkedHashMap<String,String> profileObjects = new LinkedHashMap<>();
        //profileObjects.put(actualObjects.getString("avatarUrl"),userUpdateReq.getAvatarUrl());
         profileObjects.put(actualObjects.getString("name"), userUpdateReq.getName());
        profileObjects.put(actualObjects.getString("surname"),userUpdateReq.getSurname());
        profileObjects.put(actualObjects.getString("birthDate"),userUpdateReq.getBirthDate());
        profileObjects.put(actualObjects.getString("phone"),userUpdateReq.getPhone());
        profileObjects.put(actualObjects.getString("gender"),userUpdateReq.getGender());
        profileObjects.put(actualObjects.getString("backgroundUrl"),userUpdateReq.getBackgroundUrl());
        //profileObjects.put(actualObjects.getString("blocked"),userUpdateReq.isBlocked());

        for (Map.Entry<String,String> profileObject:profileObjects.entrySet()){
            String actualResult = profileObject.getKey();
            String expectedResult =profileObject.getValue();
            Assert.assertEquals(actualResult,expectedResult, actualResult + " is not equals " + expectedResult);
        }
    }
    private void checkEditProfileData(String profileId, UserRes userUpdateReq){

        JsonPath actualObjects = JsonPath.given(profileApi.getpofileId(profileId,200));
        LinkedHashMap<String,String> profileObjects = new LinkedHashMap<>();
        profileObjects.put(actualObjects.getString("avatarUrl"),userUpdateReq.getAvatarUrl());
        profileObjects.put(actualObjects.getString("name"),userUpdateReq.getName());
        profileObjects.put(actualObjects.getString("surname"),userUpdateReq.getSurname());
        profileObjects.put(actualObjects.getString("birthDate"),userUpdateReq.getBirthDate());
        profileObjects.put(actualObjects.getString("phone"),userUpdateReq.getPhone());
        profileObjects.put(actualObjects.getString("gender"),userUpdateReq.getGender());
        profileObjects.put(actualObjects.getString("backgroundUrl"),userUpdateReq.getBackgroundUrl());
        //profileObjects.put(actualObjects.getString("blocked"),userUpdateReq.isBlocked());


        for (Map.Entry<String,String> profileObject:profileObjects.entrySet()){
            String actualResult = profileObject.getKey();
            String expectedResult =profileObject.getValue();
            Assert.assertEquals(actualResult,expectedResult, actualResult + " is not equals " + expectedResult);
        }
    }@Feature(value = "Creating,editing and deleting profile")
    @Description(value = "New profile")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can create,edit and delete profile")
    public void userCanCreateProfile() throws JsonProcessingException, UnsupportedEncodingException {
        String email = "mylen@gmail.com";
        String password = "mylenmy88";

        String name = "Den";
        String surname = "Djoni";
        String birthDate = "08-08-2011";
        String phone = "+457412589";
        String gender = "Male";
        String backgroundUrl = "";
        String blocked = "";
        String body = faker.lorem().sentence(10);
        //String imageURL = ("https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-1080x675.jpg");

        String Name = "Djain";
        String Surname = "Ivanova";
        String BirthDate = "05-07-2008";
        String Phone = "+45741258906";
        String Gender = "Male";
        String editBody = faker.lorem().sentence(20);
        //String editImageURL = ("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");

        userApi = new UserApi();
        String token = userApi.login(email, password, 200);
        userUpdateReq = new UserUpdateReq(token);

        userUpdateReq.setName(name);
        userUpdateReq.setSurname(surname);
        userUpdateReq.setBirthDate(birthDate);
        userUpdateReq.setPhone(phone);
        userUpdateReq.setGender(gender);
        userUpdateReq.setBackgroundUrl(backgroundUrl);


        userUpdateReq = new UserUpdateReq(token);
        userUpdateReq.setName(name);
        userUpdateReq.setSurname(surname);
        userUpdateReq.setBirthDate(birthDate);
        userUpdateReq.setPhone(phone);
        userUpdateReq.setGender(gender);
        userUpdateReq.setBackgroundUrl(backgroundUrl);

        profileApi = new ProfileApi(token);
        String response = profileApi.createProfile(201, userUpdateReq);
        JsonPath jsonPath = new JsonPath(response);
        String profileId;
        profileId = jsonPath.toString();
        //profileId.getBytes(profileId);
        checkProfileData(profileId,userUpdateReq);

        String responseEdit = Arrays.toString(profileId.getBytes(profileId));
        JsonPath jsonPathEdit = new JsonPath(responseEdit);
        String editProfileId = jsonPathEdit.getString("id");
        profileId.getBytes(profileId);
        checkEditProfileData(profileId,userRes);

        //Object editProfileIdId = new Object();
        //profileId.deleteUserProfile(editProfileIdId, 204);
    }

    private long[] getBytes(String profileId) {
        return new long[0];
    }

    private String getJsonObject(String id) {
        return id;
    }

    private String get(String id) {
        return id;
    }
}
