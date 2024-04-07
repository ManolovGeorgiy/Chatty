package integration;

import com.github.javafaker.Faker;
import integration.user.UserApi;
import org.testng.annotations.Test;

public class UserApiTest {

    UserApi userApi;

    Faker faker = new Faker();

    @Test
    public void testNewUserRegistration() {
        String email = "test@example.com";
        String password = "TestPassword123";
        String confirmPassword = "TestPassword123";
        String role = "user";

        userApi = new UserApi();


        userApi.registration(email, password, confirmPassword, role, 201);
        userApi.login(email,password,200);

    }
    @Test
    public void userCanRegistrationAsUser() {
        String email = faker.internet().emailAddress();
        String password = "Gazmanov11234";
        String confirmPassword = "Gazmanov11234";
        String role = "user";
        userApi = new UserApi();
        userApi.registration(email,password,confirmPassword,role,201);
    }

    }