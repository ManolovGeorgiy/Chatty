//package integration.user;
//
//import integration.ApiBase;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.greaterThan;
//
//public class UserApiTest_2 extends ApiBase {
//    @Test
//    public void testGetAllUsers() {
//        given().
//                when().
//                get("/api/users").
//                then().
//                assertThat().
//                statusCode(200).
//                body("size()", greaterThan(0));
//
//    }
//}
