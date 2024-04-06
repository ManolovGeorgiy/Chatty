package integration.user;

import integration.UserApi;
import org.testng.annotations.Test;

public class UserApiTest {

    @Test
    public void userCanWorkWithLoginViaApiTest(){
        UserApi userApi = new UserApi();
        String token = userApi.login("g.power@gmail.com","GPower3333",201);
    }
}
