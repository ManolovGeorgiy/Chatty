package e2e.tests.registration;

import com.github.javafaker.Faker;
import e2e.TestBase;

import e2e.enums.SideBarInfo;
import e2e.pages.Header;
import e2e.pages.adminPanel.AdminPanelPage;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.registration.RegistrationPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class RegistrationAndAuthorisationUserTest extends TestBase {
<<<<<<< HEAD

    Faker faker = new Faker();
LoginPage loginPage;
RegistrationPage registrationPage;
HomeBlogPage homeBlogPage;
Header header;
=======
    LoginPage loginPage;
    RegistrationPage registrationPage;
    HomeBlogPage homeBlogPage;
    Header header;
>>>>>>> 6962117 (Added ContactUsApiTest)

    @Epic(value = "User can registration and authorisation")
    @Feature(value = "The user has registered and logged in")
    @Description(value = "User can registration and authorisation")
    @Severity(SeverityLevel.BLOCKER)
<<<<<<< HEAD
    @Test(description = "User can registration")
    public void userCanRegistration(){
=======
    @Test(description = "CHATTY-16")
    public void UserCanRegistration() {
>>>>>>> 6962117 (Added ContactUsApiTest)

        String email = faker.internet().emailAddress();
        String password = "Manowar333246";
        String confirmPassword = "Manowar333246";


        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.signUp();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.optionUser();
        registrationPage.registration(email, password, confirmPassword);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.LOGIN);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();
    }
}

