package e2e.tests.Georgiy;

import e2e.TestBase;
import e2e.pages.login.LoginPage;
import e2e.utils.DataProviders;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class LoginUserTest extends TestBase {

    LoginPage loginPage;
    @Epic(value = "User can login with valid Email and Password")
    @Feature(value = "User has been logged in")
    @Description(value = "User can login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("3")
    @Test(description = "CHATTY-3")
    public void userCanLogin() {
        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
    @Epic(value = "User can login with invalid Data")
    @Feature(value = "User is not logged in")
    @Description(value = "User can login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("4")
    @Test(description = "CHATTY-47",dataProvider = "userCanNotLoginTest", dataProviderClass = DataProviders.class)
    public void userCannotLoginWithInvalidData(String email, String password, String caseName) {
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        //loginPage.waitForLoading();
        //loginPage.takeLoginPageScreenshot(caseName + "_negative_login_case");
        //loginPage.waitForLoading();

    }
}
