package integration.tests.myTests;


import integration.pages.user.GetUser;
import integration.pages.user.UserApi;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class LoginApiTest {

    UserApi userApi;
    GetUser getUser;

    @Feature(value = "admin logged in")
    @Description(value = "admin can login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("")
    @Test(description = "Admin can login")
    public void adminCanLogin() {
        String email = "g.power@gmail.com";
        String password = "GPower3333";
        userApi = new UserApi();
        String token = userApi.login(email, password, 200);
        getUser = new GetUser(token);
        String userJson = getUser.getUser();
        JsonPath object = new JsonPath(userJson);
        String userId = object.getString("id");
        System.out.println(userId);
    }

    @Feature(value = "adminPanel is not logged in")
    @Description(value = "adminPanel can't login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("")
    @Test(description = "Admin can login wit invalid password")
    public void adminCannotLoginWithInvalidPassword() {
        String email = "g.power@gmail.com";
        String password = "GPower3334";
        userApi = new UserApi();
        String token = userApi.login(email, password, 401);
        getUser = new GetUser(token);
    }

    @Feature(value = "admin can not login")
    @Description(value = "admin can not login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("")
    @Test(description = "Admin can login wit invalid email")
    public void adminCannotLoginWithInvalidEmail() {
        String email = "g.powerr@gmail.com";
        String password = "GPower3333";
        userApi = new UserApi();
        String token = userApi.login(email, password, 404);
        getUser = new GetUser(token);
    }

    @Epic(value = "admin can not login without email and password")
    @Feature(value = "admin is not logged in")
    @Description(value = "admin can not login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("")
    @Test(description = "Admin can login without email and Password ")
    public void adminCanNotLoginWithoutEmailAndPassword() {
        String email = "";
        String password = "";
        userApi = new UserApi();
        String token = userApi.login(email, password, 400);
        getUser = new GetUser(token);
    }
}
