package integration.tests;


import integration.ApiBase;
import integration.pages.user.UserApi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class ContactUsApiTest extends ApiBase {
    UserApi userApi;

    @Test
    public void testNewUserRegistration() {
        String email = "W12trieng12324@gmail.com";
        String password = "Qer123w999";
        String confirmPassword = "Qer123w999";
        String role = "user";

        userApi = new UserApi();
        userApi.registration(email, password, confirmPassword, role, 201);
        userApi.login(email, password, 200);
    }

    @Test(dependsOnMethods = "testNewUserRegistration")
    public void testUserLogin() {
        String email = "W12trieng12324@gmail.com";
        String password = "Qer123w999";
        userApi = new UserApi();
        userApi.login(email, password, 200);
    }

    @Test(dependsOnMethods = "testUserLogin")
    public void testSendMessageFeedbackViaApi() {
        RestAssured.baseURI = "http://chatty.telran-edu.de:8989/api/feedback";
        String name = "Nata";
        String email = "W1s1trieng12324@gmail.com";
        String content = "sdfgvhbjnkmlsdfcgvhbnjklasderfgtzhjsdrfghjk";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"" + name + "\", \"email\": \"" + email + "\", \"content\": \"" + content + "\" }")
                .when()
                .log().all()
                .post(baseURI)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(201);
    }
}

