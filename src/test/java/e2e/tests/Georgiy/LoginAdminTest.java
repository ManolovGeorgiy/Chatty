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
    @AllureId("2")
    @Test(description = "CHATTY-47")
    public void adminCanLogin() {
        String email = "g.power@gmail.com";
        String password = "GPower3333";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
    @Epic(value = "Admin can't login with invalid email")
    @Feature(value = "Admin is not logged in")
    @Description(value = "Admin can't login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("3")
    @Test(description = "CHATTY-15")
    public void adminCanNotLoginWithInvalidEmail() {
        String email = "gpower@gmail.com";
        String password = "GPower3333";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
    @Epic(value = "Admin can't login with invalid password")
    @Feature(value = "Admin is not logged in")
    @Description(value = "Admin can't login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("4")
    @Test(description = "CHATTY-14")
    public void adminCanNotLoginWithInvalidPassword() {
        String email = "g.power@gmail.com";
        String password = "GPower3334";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
    @Epic(value = "Admin can't login without a email and password")
    @Feature(value = "Admin is not logged in")
    @Description(value = "Admin can't login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("5")
    @Test(description = "CHATTY-14")
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
    @AllureId("6")
    @Test(description = "CHATTY-49")
    public void adminCanNotLoginWithoutInvalidEmailAndPassword() {
        String email = "gpower@gmail.com";
        String password = "GPower3334";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
    @Epic(value = "Admin can' login with invalid data")
    @Feature(value = "Admin is not logged in")
    @Description(value = "Admin can't login")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("7")
    @Test(description = "All negative Test",dataProvider = "adminCanNotLoginTest", dataProviderClass = DataProviders.class)
    public void adminCanNotLoginWithInvalidData(String email, String password,String caseName) {
        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
        loginPage.waitForLoading();
        loginPage.takeLoginPageScreenshot(caseName + "_negative_login_case");
        loginPage.waitForLoading();
    }
}
