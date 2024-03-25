package e2e.tests;

import e2e.TestBase;
import e2e.pages.*;
import org.testng.annotations.Test;

public class AdminPanelTest extends TestBase {

    LoginPage loginPage;
    RegistrationPage registrationPage;
    HomeBlogPage homeBlogPage;
    AdminPanelPage adminPanelPage;
    SideBar sideBar;

    @Test
    public void deleteAccount(){

        String emailLogin = "g.power@gmail.com";
        String passwordLogin = "GPower3333";

        String emailAccount = "RegistrationAdmin2@gmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.login(emailLogin,passwordLogin);

        adminPanelPage = new AdminPanelPage(app.driver);
        adminPanelPage.waitForLoading();
        adminPanelPage.searchAccount(emailAccount);
        adminPanelPage.waitForLoading();
        adminPanelPage.clickDeleteAccount();


    }
}

