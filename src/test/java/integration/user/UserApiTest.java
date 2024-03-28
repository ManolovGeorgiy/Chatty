package integration.user;

import integration.user.UserApi;
import org.testng.annotations.Test;

public class UserApiTest {

    UserApi userApi;


    @Test
    public void userLogin() {
        String email = "g.power@gmail.com";
        String password = "GPower3333";

        userApi = new UserApi();
        String token = userApi.login(email, password, 200);

    }
}