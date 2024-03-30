package e2e.tests.Georgiy;

import e2e.TestBase;

import e2e.enums.SideBarInfo;
import e2e.pages.Header;
import e2e.pages.adminPanel.AdminPanelPage;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.registration.RegistrationPage;
import org.testng.annotations.Test;

public class RegistrationAndAuthorisationUserTest extends TestBase {

LoginPage loginPage;
RegistrationPage registrationPage;
HomeBlogPage homeBlogPage;
Header header;
    @Test(description = "CHATTY-16")
    public void UserCanRegistration(){

        String email = "tatar@abv.bg";
        String password = "Manowar333246";
        String confirmPassword = "Manowar333246";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.signUp();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.optionUser();
        registrationPage.registration(email,password,confirmPassword);
        registrationPage.waitForLoading();

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.LOGIN);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email,password);
        loginPage.waitForLoading();
    }
}

