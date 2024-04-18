package integration.tests.profile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import integration.pages.user.GetUserApi;
import integration.pages.user.UpdateUser;
import integration.pages.user.UserApi;
import integration.schemas.UserUpdateReq;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;


public class UserCanAddData {

    UserApi userApi;
    GetUserApi getUserApi;
    UserUpdateReq userUpdateReq;
    UpdateUser updateUser;
    Faker faker = new Faker();

    @Epic(value = "User can update Profile")
    @Feature(value= "Profile updating")
    @Story(value = "User can update profile with role user")
    @Description(value = "User can update profile")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "User can update profile")
    public void userCanUpdateProfile() throws JsonProcessingException {
        String email = "user.add.data@gmail.com";
        String password = "GPower1234";
        String name = "Marta";
        String surname = "Berg";
        String birthDate = "1999-03-23T00:00:00.000Z";
        String phone = "+1234567890";
        String gender = "FEMALE";
        String image = ("https://buffer.com/library/content/images/size/w1200/2023/10/free-images.jpg");
        boolean blocked = false;

        userApi = new UserApi();
        String token = userApi.login(email, password, 200);

        getUserApi = new GetUserApi(token);
        String userJson = getUserApi.getUserInfo(200);
        JsonPath object = new JsonPath(userJson);
        String userId = object.getString("id");


        userUpdateReq = new UserUpdateReq();
        userUpdateReq.setName(name);
        userUpdateReq.setSurname(surname);
        userUpdateReq.setBirthDate(birthDate);
        userUpdateReq.setPhone(phone);
        userUpdateReq.setGender(gender);
        userUpdateReq.setAvatarUrl(image);
        userUpdateReq.setBlocked(blocked);

        updateUser = new UpdateUser(token);
        updateUser.updateUserProfile(userId, userUpdateReq, 200);
        String updatedUserJson = getUserApi.getUserInfo(200);
        JsonPath updatedUser = new JsonPath(updatedUserJson);
    }
}
