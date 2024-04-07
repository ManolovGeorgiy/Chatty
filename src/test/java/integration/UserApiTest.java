package integration;

import integration.user.UserApi;
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


        userApi.newUserRegistration(email, password, confirmPassword, role, 201);
        userApi.login(email,password,200);

    }

    }