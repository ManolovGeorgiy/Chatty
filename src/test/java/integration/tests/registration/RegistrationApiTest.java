package integration.tests.registration;

import com.github.javafaker.Faker;
import integration.pages.user.UserApi;
import org.testng.annotations.Test;

public class RegistrationApiTest {

    UserApi userApi;

    Faker faker = new Faker();

    @Test
    public void testNewUserRegistration() {
        String email = "tatar@abv.bg";
        String password = "Manowar33246";
        String confirmPassword = "Manowar33246";
        String role = "user";

        userApi = new UserApi();
        userApi.registration(email, password, confirmPassword, role, 201);
        userApi.login(email,password,200);




    }
}