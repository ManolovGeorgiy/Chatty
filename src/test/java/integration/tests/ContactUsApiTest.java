package integration.tests;


import integration.ApiBase;
import integration.pages.user.UserApi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class ContactUsApiTest extends ApiBase {
    UserApi userApi;

    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }
    private String email = generateRandomString(10) + "@gmail.com";
    private String password = "Qer123w999";
    private String role = "user";

    @Test
    public void testNewUserRegistration() {
        // email = generateRandomString(10) + "@gmail.com";
        //String email = faker.internet().emailAddress();
        //String email = "string12324@gmail.com";
        //String password = "Qer123w999";
        //String confirmPassword = "Qer123w999";
        userApi = new UserApi();
        userApi.registration(email, password, password, role, 201);
        userApi.login(email, password, 200);
    }

    @Test(dependsOnMethods = "testNewUserRegistration")
    public void testUserLogin() {
        //String email = "string12324@gmail.com";
        //String password = "Qer123w999";
        userApi = new UserApi();
        userApi.login(email, password, 200);
    }

    @Test(dependsOnMethods = "testUserLogin")
    public void testSendMessageFeedbackViaApi() {
        RestAssured.baseURI = "http://chatty.telran-edu.de:8989/api/feedback";
        String name = "Nata";
        //email = "string1@gmail.com";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"" + name + "\", \"email\": \"" + email + "\", \"content\": \"" + generateRandomString(20) + "\" }")
                .when()
                .log().all()
                .post(baseURI)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(201);
    }
}

