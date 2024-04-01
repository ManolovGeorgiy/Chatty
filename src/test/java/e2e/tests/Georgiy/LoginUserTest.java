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
    @AllureId("8")
    @Test(description = "CHATTY-3")
    public void userCanLogin() {
        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
    @Epic(value = "User can't login with invalid email")
    @Feature(value = "User is not logged in")
    @Description(value = "User can't login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("9")
    @Test(description = "CHATTY-5")
    public void adminCanNotLoginWithInvalidEmail() {
        String email = "tatara@abv.bg";
        String password = "Manowar33246";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
    @Epic(value = "User can't login with invalid password")
    @Feature(value = "User is not logged in")
    @Description(value = "User can't login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("10")
    @Test(description = "CHATTY-6")
    public void adminCanNotLoginWithInvalidPassword() {
        String email = "tatar@abv.bg";
        String password = "Mannn32";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
    @Epic(value = "User can't login without a email and password")
    @Feature(value = "User is not logged in")
    @Description(value = "User can't login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("11")
    @Test(description = "CHATTY-20")
    public void adminCanNotLoginWithoutAEmailAndPassword() {
        String email = "";
        String password = "";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
    @Epic(value = "Admin can't login with invalid email and password")
    @Feature(value = "Admin is not logged in")
    @Description(value = "Admin can't login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("12")
    @Test(description = "CHATTY-47")
    public void adminCanNotLoginWithoutInvalidEmailAndPassword() {
        String email = "tatar@abvbg";
        String password = "Manowar332466";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
    @Epic(value = "User can login with invalid Data")
    @Feature(value = "User is not logged in")
    @Description(value = "User can login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("13")
    @Test(description = "All negative Test",dataProvider = "userCanNotLoginTest", dataProviderClass = DataProviders.class)
    public void userCannotLoginWithInvalidData(String email, String password, String caseName) {
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        loginPage.waitForLoading();
        loginPage.takeLoginPageScreenshot(caseName + "_negative_login_case");
        loginPage.waitForLoading();

    }
}
