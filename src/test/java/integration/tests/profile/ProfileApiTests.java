package integration.tests.profile;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class ProfileApiTests {
    @Test
    public void testAddProfile() {
        String requestBody = "{ \"avatarUrl\": \"https://example.com/avatar.jpg\", \"name\": \"John\", \"surname\": \"Doe\", \"birthDate\": \"1990-01-01\", \"phone\": \"+1234567890\", \"gender\": \"male\", \"backgroundUrl\": \"https://example.com/background.jpg\" }";

        given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post("http://yourapi.com/profiles").
                then().
                assertThat().
                statusCode(200).
                body("id", notNullValue());
    }

    @Test
    public void testUpdateProfile() {
        String profileId = "123"; // Предполагая, что у вас есть профиль с этим идентификатором
        String requestBody = "{ \"avatarUrl\": \"https://example.com/new_avatar.jpg\", \"name\": \"Jane\", \"surname\": \"Doe\", \"birthDate\": \"1995-01-01\", \"phone\": \"+9876543210\", \"gender\": \"female\", \"backgroundUrl\": \"https://example.com/new_background.jpg\" }";

        given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                put("http://yourapi.com/profiles/" + profileId).
                then().
                assertThat().
                statusCode(200).
                body("name", equalTo("Jane"));
    }

}
