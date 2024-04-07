package integration.Admin;

import integration.user.ApiBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AdminProfileTest extends ApiBase {
    @BeforeClass
    public void setUp() {
        super.setUp(); // Вызываем метод setUp() базового класса для настройки базового URI
    }

    @Test
    public void testGetAdminProfile() {
        given().
                when().
                get("/api/admin/profile").
                then().
                assertThat().
                statusCode(200).
                body("username", equalTo("admin")).
                body("role", equalTo("administrator"));
    }
}
