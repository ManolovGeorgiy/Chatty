package integration.tests.adminapi;

import config.Config;
import integration.ApiBase;
import integration.pages.user.UserApi;

import util.UserInfoDto;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
public class AdminEditDeleteUser extends ApiBase {

    private final Config config = new Config();
    protected final String BASE_URL = config.getProjectApiUrl();
    protected final RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .build();
    UserApi userApi;

    @Feature(value = "Edit User")
    @Story(value = "Admin can edit User")
    @Description(value = "Admin can edit User")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Admin can Edit new User")
    public void adminCanLoginEditUser() {

        String email = generateRandomEmail();
        String password = "Boba9876";
        String confirmPassword = "Boba9876";
        String role = "user";

        userApi = new UserApi();
        userApi.registration(email, password, confirmPassword, role, 201);

        String emailLogin = "Boba1234@mail.ru";
        String passwordLogin = "Boba1234";
        String editUserEndpoint = "/api/users";

        userApi = new UserApi();
        String token = userApi.login(emailLogin, passwordLogin, 200);


        UserInfoDto userInfo = getUserByEmail(token,email,200).get(0);
        userInfo.setName("testName");
        userInfo.setSurname("testSurname");
        userInfo.setPhone("+1234567890");
        userInfo.setGender("MALE");

        UserInfoDto userInfoResponse = RestAssured.given()
                .spec(spec)
                .header("Authorization", "Bearer " + token)
                .when()
                .body(userInfo)
                .log().all()
                .put(editUserEndpoint + "/" + userInfo.getId())
                .then().log().all()
                .extract().as(UserInfoDto.class);

        assertNotNull(userInfoResponse);
        assertEquals("testName", userInfo.getName());
        assertEquals("testSurname", userInfo.getSurname());
        assertEquals("+1234567890", userInfo.getPhone());
        assertEquals("MALE", userInfo.getGender());
    }
    @Feature(value = "Delete User")
    @Story(value = "Admin can Delete User")
    @Description(value = "Admin can Delete User")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Admin can Delete new User")
    public void adminCanLoginAndDeleteUser() {
        String email = generateRandomEmail();
        String password = "Boba9876";
        String confirmPassword = "Boba9876";
        String role = "user";

        userApi = new UserApi();
        userApi.registration(email, password, confirmPassword, role, 201);

        String emailLogin = "Boba1234@mail.ru";
        String passwordLogin = "Boba1234";
        String deleteUserEndpoint = "/api/users";

        userApi = new UserApi();
        String token = userApi.login(emailLogin, passwordLogin, 200);

        UserInfoDto userInfo = getUserByEmail(token, email, 200).get(0);
        assertNotNull(userInfo);

        RestAssured.given()
                .spec(spec)
                .header("Authorization", "Bearer " + token)
                .when()
                .body(userInfo)
                .log().all()
                .delete(deleteUserEndpoint + "/" + userInfo.getId())
                .then().log().all()
                .extract().response();

        checkUserDelete(token, email, 404);

    }

}