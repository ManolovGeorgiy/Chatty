package integration;

import integration.user.UserApi;
import org.testng.annotations.Test;

public class UserApiTest {

    UserApi userApi;
    @Test
    public void testNewUserRegistration() {

        // Задаем данные для регистрации нового пользователя
        String email = "g.power@gmail.com";
        String password = "GPower3333";


        userApi = new UserApi();

        String token = userApi.login(email,password,200);
        userApi.refreshToken(token,200);

    }
}
