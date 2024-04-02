package integration;

import integration.user.AdminApi;
import org.testng.annotations.Test;

public class AdminApiTest extends AdminApi {

    AdminApi adminApi;


    @Test
    public void adminLogin() {
        String email = "g.power@gmail.com";
        String password = "GPower3333";

        adminApi = new AdminApi();
        String token;
        token = adminApi.login(email, password, 200);

    }
}