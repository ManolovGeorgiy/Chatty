package integration.tests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;


public class ContactUsApiTest extends UserRegistrationApiTest {
    @Test
    public void testSendMessageFeedbackViaApi() {

        RestAssured.baseURI = "http://chatty.telran-edu.de:8989/api/feedback";
        String name = "Nata";
        String email = "string1@gmail.com";
        String content = "asdfgzhjwsedrftgzhujwsedrftgzhuj";

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

