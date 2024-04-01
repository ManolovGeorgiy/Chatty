package integration;

import integration.user.UserApi;
import org.testng.annotations.Test;

public class UserApiTest {

    UserApi userApi;


    @Test
    public void userLogin() {
        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        userApi = new UserApi();
        String token = userApi.login(email, password, 200);

    }
}