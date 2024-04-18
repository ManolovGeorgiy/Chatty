package e2e.tests.registration;

import e2e.TestBase;
import e2e.enums.SideBarInfo;
import e2e.pages.Header;
import e2e.pages.adminPanel.AdminPanelPage;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.registration.RegistrationPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class RegistrationAndAuthorisationAdminTest extends TestBase {
    LoginPage loginPage;
    RegistrationPage registrationPage;
    HomeBlogPage homeBlogPage;
    Header header;
    AdminPanelPage adminPanelPage;

    @Epic(value = "adminPanel can registration and authorisation")
    @Feature(value = "The administrator has registered and logged in")
    @Description(value = "adminPanel can registration and authorisation")
    @Severity(SeverityLevel.BLOCKER)
<<<<<<< HEAD
    @Test(description = "admin can registration")
    public void adminCanRegistration(){
=======
    @Test(description = "CHATTY-04")
    public void AdminCanRegistration() {
>>>>>>> 6962117 (Added ContactUsApiTest)

        String email = "RegistrationAdmin@gmail.com";
        String password = "Admin3333";
        String confirmPassword = "Admin3333";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.signUp();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.optionAdmin();
        registrationPage.registration(email, password, confirmPassword);
        registrationPage.waitForLoading();

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.LOGIN);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);
        loginPage.waitForLoading();

        adminPanelPage = new AdminPanelPage(app.driver);
        adminPanelPage.waitForLoading();

        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.LOGIN);
    }

    @Epic(value = "adminPanel can not registration with valid Email")
    @Feature(value = "The administrator has not registered")
    @Description(value = "adminPanel can not registration ")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "CHATTY-50")
    public void AdminCanNotRegistrationWithValidEmail() {

        String email = "g.power@gmail.com";
        String password = "Admin3333";
        String confirmPassword = "Admin3333";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.signUp();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.optionAdmin();
        registrationPage.registration(email, password, confirmPassword);
        registrationPage.waitForLoading();
        assertTrue("Email already exists!", registrationPage.textError());
        registrationPage.takeLoginPageScreenshot("Admin_can't_registration");
    }
}
