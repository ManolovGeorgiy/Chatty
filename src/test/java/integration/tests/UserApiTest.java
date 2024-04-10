package integration.tests;

import com.github.javafaker.Faker;
import integration.pages.user.UserApi;
import org.testng.annotations.Test;

public class UserApiTest {

    UserApi userApi;

    Faker faker = new Faker();

    @Test
    public void testNewUserRegistration() {
        String email = "tes8@gmail.com";
        String password = "TestPassword123";
        String confirmPassword = "TestPassword123";
        String role = "user";

        userApi = new UserApi();


        userApi.registration(email, password, confirmPassword, role, 201);
        userApi.login(email,password,200);




    }
}