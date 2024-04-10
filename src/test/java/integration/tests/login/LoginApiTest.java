package integration.tests.login;


import integration.pages.user.UserApi;
import org.testng.annotations.Test;

public class LoginApiTest {

    UserApi userApi;


    @Test
    public void userCanLogin() {
        String email = "g.power@gmail.com";
        String password = "GPower3333";


        userApi = new UserApi();
        userApi.login(email, password, 200);

    }

    @Test
    public void userCanNotLoginWitInvalidEmail() {
        String email = "gpower@gmail.com";
        String password = "GPower3333";

        userApi = new UserApi();
        userApi.login(email, password, 200);
    }
}
