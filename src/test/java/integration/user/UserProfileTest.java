package integration.user;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserProfileTest extends ApiBase{
    @BeforeClass
    public void setUp() {
        super.setUp(); // Вызываем метод setUp() базового класса для настройки базового URI
    }

    @Test
    public void testGetUserProfile() {
        // Предположим, что для получения профиля пользователя требуется передать идентификатор пользователя
        int userId = 1;

        given().
                when().
                get("/api/users/{userId}", userId). // Здесь {userId} будет заменен на фактический идентификатор пользователя
                then().
                assertThat().
                statusCode(200).
                body("id", equalTo(userId));
    }
}
