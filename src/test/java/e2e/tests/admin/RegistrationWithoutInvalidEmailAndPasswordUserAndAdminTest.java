package e2e.tests.admin;

import e2e.TestBase;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.registration.RegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static e2e.enums.RegistrationErrorMessages.*;

public class RegistrationWithoutInvalidEmailAndPasswordUserAndAdminTest extends TestBase {

    LoginPage loginPage;
    RegistrationPage registrationPage;
    HomeBlogPage homeBlogPage;
    Header header;

    @Epic(value = "User can registration and authorisation without invalid email and password")
    @Feature(value = "The user hasn't registered and logged in")
    @Description(value = "User cannot registration and authorisation")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("")
    @Test(description = "CHATTY-51")
    public void UserCannotRegistration(){

        String email = "incorrect";
        String password = "Manow";
        String confirmPassword = "Manowar333246";


        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.signUp();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.optionUser();
        registrationPage.registration(email,password,confirmPassword);

        Assert.assertEquals(registrationPage.emailErrorMessage.getText(), INCORRECT_EMAIL.getValue());
        Assert.assertEquals(registrationPage.passwordErrorMessage.getText(), INCORRECT_PASSWORD.getValue());
        Assert.assertEquals(registrationPage.passwordDoNotMatchErrorMassage.getText(),NOT_MATCH_PASSWORD.getValue());
    }
}
