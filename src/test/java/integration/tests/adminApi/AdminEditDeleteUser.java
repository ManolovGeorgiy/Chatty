package integration.tests.adminApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import config.Config;

import integration.pages.adminPanel.DeleteUserApi;
import integration.pages.profile.AddDataUser;
import integration.pages.user.GetUserApi;
import integration.pages.user.UpdateUser;
import integration.pages.user.UserApi;


import integration.schemas.UserRes;
import integration.schemas.UserResForAdmin;
import integration.schemas.UserUpdateReq;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
public class AdminEditDeleteUser  {

    Faker faker = new Faker();
    UserApi userApi;
    GetUserApi getUserApi;
    UserRes userRes;
    AddDataUser addDataUser;
    UpdateUser updateUser;
    UserUpdateReq userUpdateReq;
    DeleteUserApi deleteUserApi;

    @Feature(value = "Edit User")
    @Story(value = "Admin can edit User")
    @Description(value = "Admin can edit User")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Admin can Edit new User")
    public void adminCanDeleteUser() throws JsonProcessingException {

        String email = "bobo@gmail.com";
        String password = "Boba9876";
        String confirmPassword = "Boba9876";
        String role = "user";

        String emailAdminLogin = "g.power@gmail.com";
        String passwordAdminLogin = "GPower3333";

        userApi = new UserApi();
        userApi.registration(email, password, confirmPassword, role, 201);
        String token = userApi.login(email, password, 200);
        getUserApi = new GetUserApi(token);
        String userJson = getUserApi.getUserInfo(200);
        JsonPath object = new JsonPath(userJson);
        String userId = object.getString("id");

        userRes = new UserRes();
        userRes.setName("Bobo");
        userRes.setSurname("Bobo");
        userRes.setBirthDate("1995-06-27T00:00:00.000Z");
        userRes.setPhone("+1234567890");
        userRes.setGender("FEMALE");
        userRes.setAvatarUrl("https://imgv3.fotor.com/images/slider-image/Female-portrait-picture-enhanced-with-better-clarity-and-higher-quality-using-Fotors-free-online-AI-photo-enhancer.jpg");

        addDataUser = new AddDataUser(token);
        addDataUser.updateUserProfile(userId,userRes,200);

        userUpdateReq = new UserUpdateReq();
        userUpdateReq.setName("Marta");
        userUpdateReq.setSurname("Bobovna");
        userUpdateReq.setBirthDate("1983-06-12T00:00:00.000Z");
        userUpdateReq.setPhone("+2222567890");
        userUpdateReq.setGender("FEMALE");
        userUpdateReq.setAvatarUrl("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");

        updateUser = new UpdateUser(token);
        updateUser.updateUserProfile(userId, userUpdateReq, 200);

        Assert.assertEquals("Bobo",userRes.getName());
        Assert.assertEquals("Bobo",userRes.getSurname());
        Assert.assertEquals("1995-06-27T00:00:00.000Z",userRes.getBirthDate());
        Assert.assertEquals("+1234567890",userRes.getPhone());
        Assert.assertEquals("FEMALE",userRes.getGender());
        Assert.assertEquals("https://imgv3.fotor.com/images/slider-image/Female-portrait-picture-enhanced-with-better-clarity-and-higher-quality-using-Fotors-free-online-AI-photo-enhancer.jpg",userRes.getAvatarUrl());

        Assert.assertEquals("Marta",userUpdateReq.getName());
        Assert.assertEquals("Bobovna",userUpdateReq.getSurname());
        Assert.assertEquals("1983-06-12T00:00:00.000Z",userUpdateReq.getBirthDate());
        Assert.assertEquals("+2222567890",userUpdateReq.getPhone());
        Assert.assertEquals("FEMALE",userUpdateReq.getGender());
        Assert.assertEquals("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg",userUpdateReq.getAvatarUrl());


        String tokenAdmin = userApi.login(emailAdminLogin, passwordAdminLogin, 200);
        getUserApi = new GetUserApi(tokenAdmin);

        deleteUserApi = new DeleteUserApi(tokenAdmin);
        deleteUserApi.deleteUser(204,userId);




//    }
//    @Feature(value = "Delete User")
//    @Story(value = "Admin can Delete User")
//    @Description(value = "Admin can Delete User")
//    @Severity(SeverityLevel.BLOCKER)
//    @Test(description = "Admin can Delete new User")
//    public void adminCanLoginAndDeleteUser() {
//        String email = generateRandomEmail();
//        String password = "Boba9876";
//        String confirmPassword = "Boba9876";
//        String role = "user";
//
//        userApi = new UserApi();
//        userApi.registration(email, password, confirmPassword, role, 201);
//
//        String emailLogin = "Boba1234@mail.ru";
//        String passwordLogin = "Boba1234";
//        String deleteUserEndpoint = "/api/users";
//
//        userApi = new UserApi();
//        String token = userApi.login(emailLogin, passwordLogin, 200);
//
//        UserInfoDto userInfo = getUserByEmail(token, email, 200).get(0);
//        assertNotNull(userInfo);
//
//        RestAssured.given()
//                .spec(spec)
//                .header("Authorization", "Bearer " + token)
//                .when()
//                .body(userInfo)
//                .log().all()
//                .delete(deleteUserEndpoint + "/" + userInfo.getId())
//                .then().log().all()
//                .extract().response();
//
//        checkUserDelete(token, email, 404);
//
//    }
    }

}