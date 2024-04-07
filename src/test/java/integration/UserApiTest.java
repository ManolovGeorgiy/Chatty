package integration;

import integration.user.UserApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest {

    UserApi userApi;

    @Test
    public void testNewUserRegistration() {
        String email = "test@example.com";
        String password = "TestPassword123";
        String confirmPassword = "TestPassword123";
        String role = "user";

        userApi = new UserApi();

        // Для регистрации пользователя должен использоваться метод POST
        userApi.newUserRegistration(email, password, confirmPassword, role, 201);
        userApi.login(email,password,200);

    }

    }