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

    Faker faker = new Faker();
LoginPage loginPage;
RegistrationPage registrationPage;
HomeBlogPage homeBlogPage;
Header header;

    @Epic(value = "User can registration and authorisation")
    @Feature(value = "The user has registered and logged in")
    @Description(value = "User can registration and authorisation")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("14")
    @Test(description = "CHATTY-16")
    public void userCanRegistration(){
    @Test(description = "User can registration")
    public void userCanRegistration(){

        String email = "userdeletepost@abv.bg";
        String email = faker.internet().emailAddress();
        String password = "Manowar333246";
        String confirmPassword = "Manowar333246";


        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.signUp();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.optionUser();
        registrationPage.registration(email,password,confirmPassword);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.LOGIN);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email,password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();
    }
}

