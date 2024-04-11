package integration;

import com.github.javafaker.Faker;
import integration.user.UserApi;
import org.testng.annotations.Test;

public class UserApiTest {

    UserApi userApi;

    Faker faker = new Faker();

    @Test
    public void testNewUserRegistration() {
        String email = faker.internet().emailAddress();
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
        String password = "Tatata123";
        String confirmPassword = "Tatata123";
        String role = "user";
        userApi = new UserApi();
        userApi.registration(email,password,confirmPassword,role,201);
    }

    }