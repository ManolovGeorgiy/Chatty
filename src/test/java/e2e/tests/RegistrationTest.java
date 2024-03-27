package e2e.tests;

import e2e.TestBase;

import e2e.pages.login.LoginPage;
import e2e.pages.registration.RegistrationPage;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

LoginPage loginPage;
RegistrationPage registrationPage;
    @Test
    public void UserCanRegistration(){

        String email = "registrationUser1@gmail.com";
        String password = "User3333";
        String confirmPassword = "User3333";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.signUp();
        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.optionUser();
        registrationPage.registration(email,password,confirmPassword);
        registrationPage.waitForLoading();

    }

    @Test
    public void AdminCanRegistration(){

        String email = "RegistrationAdmin@gmail.com";
        String password = "Admin3333";
        String confirmPassword = "Admin3333";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.signUp();
        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.optionAdmin();
        registrationPage.registration(email,password,confirmPassword);
        registrationPage.waitForLoading();

    }
}

