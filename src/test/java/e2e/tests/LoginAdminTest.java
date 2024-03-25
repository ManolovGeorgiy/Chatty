package e2e.tests;

import e2e.TestBase;
import e2e.pages.LoginPage;
import e2e.utils.DataProviders;
import org.testng.annotations.Test;

public class LoginAdminTest extends TestBase {

    LoginPage loginPage;
    @Test
    public void adminCanLogin() {
        String email = "g.power@gmail.com";
        String password = "GPower3333";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
    @Test(dataProvider = "adminCanNotLoginTest", dataProviderClass = DataProviders.class)
    public void userCannotLoginWithInvalidData(String email, String password) {
        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
}
