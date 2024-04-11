package integration.Admin;
import integration.ApiBase;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AdminApiTest extends ApiBase {
    @Test
    public void testGetAdminInfo() {
        given().
                when().
                get("/api/admin/info").
                then().
                assertThat().
                statusCode(200).
                body("username", equalTo("admin")).
                body("role", equalTo("administrator"));
    }

    // Продолжайте добавлять другие тесты здесь
}


