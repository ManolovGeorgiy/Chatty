package integration.tests.login;


import integration.pages.user.UserApi;
import integration.pages.user.UserInfo;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class LoginApiTest {

    UserApi userApi;
    UserInfo userInfo;

    @Test
    public void userCanLogin() {
        String email = "g.power@gmail.com";
        String password = "GPower3333";


        userApi = new UserApi();
        String token = userApi.login(email, password, 200);
        userInfo = new UserInfo(token);
        String userJson = userInfo.getUser();
        JsonPath object = new JsonPath(userJson);
        String userId = object.getString("id");
        System.out.println(userId);


    }

    @Feature(value= "User login")
    @Story(value = "User can login with role user")
    @Description(value = "User can not login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User can not login wit invalid email")
    public void userCanNotLoginWitInvalidEmail() {
        String email = "gpower@gmail.com";
        String password = "GPower3333";

        userApi = new UserApi();
        userApi.login(email, password, 200);
    }
}
