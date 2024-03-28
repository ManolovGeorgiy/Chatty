package e2e.tests.Georgiy;

import e2e.TestBase;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import org.testng.annotations.Test;

public class ProbTest extends TestBase {

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;

    @Test
    public void userCanLogin() {
        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);


        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();
        homeBlogPage.clickDraftButton();
    }
}
