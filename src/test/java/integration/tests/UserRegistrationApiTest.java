package integration.tests;

import com.github.javafaker.Faker;
import integration.pages.user.UserApi;
import org.testng.annotations.Test;

public class UserRegistrationApiTest {

    UserApi userApi;

    Faker faker = new Faker();

    @Test
    public void testNewUserRegistration() {
        //String email = faker.internet().emailAddress();
        String email = "string12@gmail.com";
        String password = "Qer123w999";
        String confirmPassword = "Qer123w999";
        String role = "user";

        userApi = new UserApi();

        userApi.registration(email, password, confirmPassword, role, 201);
        userApi.login(email,password,200);
    }
}