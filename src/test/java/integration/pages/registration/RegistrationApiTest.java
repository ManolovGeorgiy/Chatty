package integration.pages.registration;

import com.github.javafaker.Faker;
import integration.pages.user.UserApi;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class RegistrationApiTest {

    UserApi userApi;

    Faker faker = new Faker();


    @Feature(value = "The user has registered")
    @Description(value = "User can registration")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "New user can registration")
    public void UserCanRegistration() {
        String email = faker.internet().emailAddress();
        String password = "Manowar33246";
        String confirmPassword = "Manowar33246";
        String role = "user";

        userApi = new UserApi();
        userApi.registration(email, password, confirmPassword, role, 201);
        userApi.login(email, password, 200);
    }

    @Feature(value = "The user has not registered")
    @Description(value = "User can not registration with invalid password")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "New user can registration with invalid password")
    public void userCanNotRegistrationWithInvalidPassword() {
        String email = "user.can.registration@gmail.com";
        String password = "Mano1234";
        String confirmPassword = "Mano12345";
        String role = "user";
        userApi = new UserApi();
        userApi.registration(email, password, confirmPassword, role, 400);
    }

    @Feature(value = "The user has not registered")
    @Description(value = "User can not registration with invalid email")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "New user can registration wit invalid email")
    public void userCanNotRegistrationWithInvalidEmail() {
        String email = "user.can.registrationgmail.com";
        String password = "Mano1234";
        String confirmPassword = "Mano1234";
        String role = "user";
        userApi = new UserApi();
        userApi.registration(email, password, confirmPassword, role, 400);
    }

    @Test
    public void userCanNotRegistrationWithoutData() {
        String email = "";
        String password = "";
        String confirmPassword = "";
        String role = "user";
        userApi = new UserApi();
        userApi.registration(email, password, confirmPassword, role, 400);
    }
}