package integration.tests.admin;
import integration.ApiBase;
import integration.pages.adminPanel.AdminApi;
import integration.pages.adminPanel.AdminCreateUser;
import integration.pages.adminPanel.AdminEditUser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AdminCanCreateEditAndDeleteUser extends ApiBase {

    AdminApi adminApi;
    private String baseURL = "http://chatty.telran-edu.de:8089";
    private String email = "Boba1234@mail.ru";
    private String password = "Boba1234";
    private String authToken;



    @Test(description = "Admin can edit a user")
    public void adminCanEditUser() {
        // LOGIN
        adminApi = new AdminApi();
    String token = adminApi.loginAdmin(email,password,200);



//    @Test(description = "Admin can delete a user")
//    public void adminCanDeleteUser() {
//        given()
//                .contentType("application/json")
//                .header("Authorization", "Bearer " + authToken)
//                .when()
//                .delete(baseURL + "/users/{userId}", userId)
//                .then()
//                .statusCode(204);
    }
}
