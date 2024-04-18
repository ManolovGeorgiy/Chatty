package integration.tests;

import integration.ApiBase;
import integration.pages.user.UserApi;
import org.testng.annotations.Test;

public class LoginApiTest extends ApiBase {
    UserApi userApi;
    @Test
    public void testUserLogin() {
        String email = "string12@gmail.com";
        String password = "Qer123w999";
        userApi = new UserApi();
        userApi.login(email, password, 200);
    }
}
