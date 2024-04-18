package integration.tests.adminApi;

import com.github.javafaker.Faker;
import config.Config;

import integration.pages.user.GetUserApi;
import integration.pages.user.UserApi;


import integration.schemas.UserRes;
import integration.schemas.UserResForAdmin;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
public class AdminEditDeleteUser  {

    Faker faker = new Faker();
    UserApi userApi;
    GetUserApi getUserApi;
    UserResForAdmin userResForAdmin;

    @Feature(value = "Edit User")
    @Story(value = "Admin can edit User")
    @Description(value = "Admin can edit User")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Admin can Edit new User")
    public void adminCanLoginEditUser() {

        String email = "bobo@gmail.com";
        String password = "Boba9876";
        String confirmPassword = "Boba9876";
        String role = "user";


        String emailAdminLogin = "Boba1234@mail.ru";
        String passwordAdminLogin = "Boba1234";


        userApi = new UserApi();
        userApi.registration(email, password, confirmPassword, role, 201);
        String token = userApi.login(email, password, 200);
        getUserApi = new GetUserApi(token);
        String userJson = getUserApi.getUserInfo(200);
        JsonPath object = new JsonPath(userJson);
        String userId = object.getString("id");


        userResForAdmin = new UserResForAdmin();
        userResForAdmin.setName("Bobo");
        userResForAdmin.setSurname("Bobo");
        userResForAdmin.setBirthDate("");
        userResForAdmin.setPhone("+1234567890");
        userResForAdmin.setGender("MALE");
        userResForAdmin.setAvatarUrl("https://imgv3.fotor.com/images/slider-image/Female-portrait-picture-enhanced-with-better-clarity-and-higher-quality-using-Fotors-free-online-AI-photo-enhancer.jpg");
        userResForAdmin.setBlocked(false);




//        assertNotNull(userInfoResponse);
//        assertEquals("testName", userInfo.getName());
//        assertEquals("testSurname", userInfo.getSurname());
//        assertEquals("+1234567890", userInfo.getPhone());
//        assertEquals("MALE", userInfo.getGender());
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