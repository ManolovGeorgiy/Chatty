package e2e.tests.Georgiy;

import e2e.TestBase;
import e2e.pages.login.LoginPage;
import e2e.utils.DataProviders;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class LoginAdminTest extends TestBase {

    LoginPage loginPage;
    @Epic(value = "Admin can login with valid Email and Password")
    @Feature(value = "admin has been logged in")
    @Description(value = "admin can login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("3")
    @Test(description = "CHATTY-47")
    public void adminCanLogin() {
        String email = "g.power@gmail.com";
        String password = "GPower3333";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
    @Epic(value = "Admin can' login with invalid data")
    @Feature(value = "admin was not authorized")
    @Description(value = "admin was not authorized")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("CHATTY-47")
    @Test(dataProvider = "adminCanNotLoginTest", dataProviderClass = DataProviders.class)
    public void userCannotLoginWithInvalidData(String email, String password) {
        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
}
