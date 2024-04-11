package integration.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ContactUsApiTest {

    @Test
    public void testSendMessageFeedbackViaApi() {

        RestAssured.baseURI = "http://chatty.telran-edu.de:8989/api/feedback";
        String userName = "Feedback";
        String userEmail = "newtest@gmail.com";
        String userMessage = "Text message feedback";

        given().
                contentType(ContentType.JSON).
                body("{ \"userName\": \"" + userName + "\", \"userEmail\": \"" + userEmail + "\", \"userMessage\": \"" + userMessage + "\" }").
                when().
                post("/api/feedback").
                then().
                assertThat().
                statusCode(201).
                body("message", equalTo("Feedback submitted successfully!"));
    }
}
