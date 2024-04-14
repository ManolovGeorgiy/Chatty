package e2e.tests.post;

import e2e.TestBase;
import e2e.enums.MenuInfo;
import e2e.pages.Header;
import e2e.pages.adminPanel.AdminPanelPage;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class DraftPostTest extends TestBase {

    LoginPage loginPage;
    AdminPanelPage adminPanelPage;
    HomeBlogPage homeBlogPage;
    Header header;

    @Epic(value = "adminPanel can login with valid Email and Password")
    @Feature(value = "admin has been logged in")
    @Description(value = "admin can login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "CHATTY-47")
    public void editDraftPost() {
        String email = "g.power@gmail.com";
        String password = "GPower3333";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

        adminPanelPage = new AdminPanelPage(app.driver);
        adminPanelPage.waitForLoading();

        header = new Header(app.driver);
        header.clickHome();

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.tabMenu(MenuInfo.MYDRAFTS);
        homeBlogPage.waitForLoading();

    }
}
