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

import java.util.LinkedHashMap;
import java.util.Map;

public class UserCanUpdateProfileApiTest {
    Faker faker = new Faker();
    UserApi userApi;
    ProfileApi profileApi ;
    UserUpdateReq userUpdateReq;
    UserRes userRes;

    private void checkProfileData(String profileId, UserUpdateReq userUpdateReq){

        JsonPath actualObjects = JsonPath.given(profileApi.getpofileId(profileId,200));
        LinkedHashMap<String,String> profileObjects = new LinkedHashMap<>();
        profileObjects.put(actualObjects.getString("name"),userUpdateReq.getName());
        profileObjects.put(actualObjects.getString("surname"),userUpdateReq.getSurname());
        profileObjects.put(actualObjects.getString("birthDate"),userUpdateReq.getBirthDate());
        profileObjects.put(actualObjects.getString("phone"),userUpdateReq.getPhone());
        profileObjects.put(actualObjects.getString("gender"),userUpdateReq.getGender());
        profileObjects.put(actualObjects.getString("backgroundUrl"),userUpdateReq.getBackgroundUrl());

        for (Map.Entry<String,String> profileObject:profileObjects.entrySet()){
            String actualResult = profileObject.getKey();
            String expectedResult =profileObject.getValue();
            Assert.assertEquals(actualResult,expectedResult, actualResult + " is not equals " + expectedResult);
        }
    }
    private void checkEditProfileData(String profileId, UserUpdateReq userUpdateReq){

        JsonPath actualObjects = JsonPath.given(profileApi.getpofileId(profileId,200));
        LinkedHashMap<String,String> profileObjects = new LinkedHashMap<>();
        profileObjects.put(actualObjects.getString("name"),userUpdateReq.getName());
        profileObjects.put(actualObjects.getString("surname"),userUpdateReq.getSurname());
        profileObjects.put(actualObjects.getString("birthDate"),userUpdateReq.getBirthDate());
        profileObjects.put(actualObjects.getString("phone"),userUpdateReq.getPhone());
        profileObjects.put(actualObjects.getString("gender"),userUpdateReq.getGender());
        profileObjects.put(actualObjects.getString("backgroundUrl"),userUpdateReq.getBackgroundUrl());

        for (Map.Entry<String,String> profileObject:profileObjects.entrySet()){
            String actualResult = profileObject.getKey();
            String expectedResult =profileObject.getValue();
            Assert.assertEquals(actualResult,expectedResult, actualResult + " is not equals " + expectedResult);
        }
    }@Feature(value = "Creating,editing and deleting profile")
    @Description(value = "New profile")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can create,edit and delete profile")
    public void userCanUpdateYourProfile() throws JsonProcessingException {
        String email = "mylen@gmail.com";
        String password = "mylenmy88";

        String Name = "Jon";
        String Surname = "Jonny";
        String BirthDate = "05-08-2000";
        String Phone = "+45896235";
        String Gender = "Male";
        String BackgroundUrl = "https://www.pinterest.com/pin/700802392041934450/";
        //String imageURL = ("https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-1080x675.jpg");

        String name = "Sally";
        String surname = "Born";
        String birthDate = "07-07-2001";
        String phone = "+45896277";
        String gender = "Female";
        String backgroundUrl = "https://www.pinterest.com/pin/700802392043046586/";
        //String editBody = faker.lorem().sentence(20);
        //String editImageURL = ("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");

        userApi = new UserApi();
        String token = userApi.login(email, password, 200);

        UserUpdateReq userUpdateReq = new UserUpdateReq(name, surname, birthDate, phone, gender, backgroundUrl);
        userUpdateReq.setName(name);
        userUpdateReq.setSurname(surname);
        userUpdateReq.setBirthDate(birthDate);
        userUpdateReq.setPhone(phone);
        userUpdateReq.setGender(gender);
        userUpdateReq.setBackgroundUrl(backgroundUrl);

        userRes = new UserRes();
        userRes.setName(name);
        userRes.setSurname(surname);
        userRes.setBirthDate(birthDate);
        userRes.setPhone(phone);
        userRes.setGender(gender);
        userRes.setBackgroundUrl(backgroundUrl);

        profileApi = new ProfileApi(token);
        String response = profileApi.createProfile(201, userUpdateReq);
        JsonPath jsonPath = new JsonPath(response);
        String profileId;
        profileId = String.valueOf(jsonPath.getUUID("id"));
        //System.out.println("Profile ID: " + profileId);
        profileApi.getpofileId(profileId,200);
        checkProfileData(profileId,userUpdateReq);

        String responseEdit = profileId.toString();
        JsonPath jsonPathEdit = new JsonPath(responseEdit);
        String editProfileId = jsonPathEdit.getString("id");
        profileApi.getpofileId(profileId,200);
        checkProfileData(profileId,userUpdateReq);



        profileApi.deleteUserProfile(userRes, 204);
    }

    private String getUUID(String id) {
        return id;
    }

    private String toString(String profileId, UserRes userRes, int i) {
        return profileId;
    }
}

