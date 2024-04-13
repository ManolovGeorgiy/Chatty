package integration.tests.myTests;

import com.github.javafaker.Faker;
import integration.pages.user.UserApi;
import org.testng.annotations.Test;

public class RegistrationApiTest {

    UserApi userApi;

    Faker faker = new Faker();

    @Test
    public void testNewUserRegistration() {
        String email = faker.internet().emailAddress();
        String password = "Manowar33246";
        String confirmPassword = "Manowar33246";
        String role = "user";

        userApi = new UserApi();
        userApi.registration(email, password, confirmPassword, role, 201);
        userApi.login(email,password,200);
    }
    @Test
    public void userCanNotRegistrationWithInvalidPassword(){
        String email = "user.can.registration@gmail.com";
        String password = "Mano1234";
        String confirmPassword = "Mano12345";
        String role = "user";
        userApi = new UserApi();
        userApi.registration(email,password,confirmPassword,role,400);
    }
    @Test
    public void userCanNotRegistrationWithInvalidEmail(){
        String email = "user.can.registrationgmail.com";
        String password = "Mano1234";
        String confirmPassword = "Mano1234";
        String role = "user";
        userApi = new UserApi();
        userApi.registration(email,password,confirmPassword,role,400);
    }
    @Test
    public void userCanNotRegistrationWithoutData(){
        String email = "";
        String password = "";
        String confirmPassword = "";
        String role = "user";
        userApi = new UserApi();
        userApi.registration(email,password,confirmPassword,role,400);
    }
}