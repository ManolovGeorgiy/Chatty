package e2e.tests;

import e2e.TestBase;
import e2e.pages.LoginPage;
import e2e.utils.DataProviders;
import org.testng.annotations.Test;

public class LoginUserTest extends TestBase {

    LoginPage loginPage;
    @Test
    public void userCanLogin() {
        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }

    @Test(dataProvider = "userCanNotLoginTest", dataProviderClass = DataProviders.class)
    public void userCannotLoginWithInvalidData(String email, String password) {
        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
}
