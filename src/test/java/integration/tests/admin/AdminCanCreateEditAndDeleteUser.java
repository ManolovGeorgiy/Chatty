package integration.tests.admin;
import integration.ApiBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AdminCanCreateEditAndDeleteUser extends ApiBase {
    private String baseURL = "http://chatty.telran-edu.de:8089";
    private String email = "Boba1234@mail.ru";
    private String password = "Boba1234";
    private String authToken;

    @BeforeClass
    public void loginAsAdmin() {
        authToken = given()
                .contentType("application/json")
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                .when()
                .post(baseURL + "/auth/login")
                .then()
                .extract().jsonPath().getString("token");
    }

    @Test(description = "Admin can create a user")
    public void adminCanCreateUser() {
        given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + authToken)
                .body("{\"username\": \"testuser\", \"email\": \"testuser@example.com\", \"password\": \"Test1234\"}")
                .when()
                .post(baseURL + "/users")
                .then()
                .statusCode(201);
    }

//    @Test(description = "Admin can edit a user")
//    public void adminCanEditUser() {
//        given()
//                .contentType("application/json")
//                .header("Authorization", "Bearer " + authToken)
//                .body("{\"username\": \"newusername\"}")
//                .when()
//                .put(baseURL + "/users/{userId}", userId)
//                .then()
//                .statusCode(200);
//    }

//    @Test(description = "Admin can delete a user")
//    public void adminCanDeleteUser() {
//        given()
//                .contentType("application/json")
//                .header("Authorization", "Bearer " + authToken)
//                .when()
//                .delete(baseURL + "/users/{userId}", userId)
//                .then()
//                .statusCode(204);
//    }
}
