package e2e.tests.contactUs;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.enums.SideBarInfo;
import e2e.pages.Header;
import e2e.pages.adminPanel.AdminPanelPage;
import e2e.pages.contactUs.ContactUsPage;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.registration.RegistrationPage;
import io.qameta.allure.Description;
<<<<<<< HEAD
import io.qameta.allure.Feature;
=======
>>>>>>> origin/dev_Natalie
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.AssertJUnit.assertTrue;

public class ContactUsNegativeTest extends TestBase {

    Faker faker = new Faker(new Locale("ENGLISH"));

    RegistrationPage registrationPage;
    LoginPage loginPage;
    Header header;
    HomeBlogPage homeBlogPage;
    ContactUsPage contactUsPage;
    AdminPanelPage adminPanelPage;

    private void checkFeedbackData(ContactUsPage page, String userName, String userEmail, String userContent) {
        String actualUserName = page.getUserName();
        String actualUserEmail = page.getUserEmail();
        String actualUserContent = page.getUserContent();
        Assert.assertEquals(actualUserName, userName, actualUserName + " is not equal " + userName);
        Assert.assertEquals(actualUserEmail, userEmail, actualUserEmail + " is not equal " + userEmail);
        Assert.assertEquals(actualUserContent, userContent, actualUserContent + " is not equal " + userContent);
    }

<<<<<<< HEAD
    @Description(value = "User can not send feedback")
    @Feature(value = "User can not sent a message")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "CHATTY-23")
=======
    @Description(value = "User can not send setFeedbackForm")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "User can not send message")
>>>>>>> origin/dev_Natalie
    public void userCanNotSendMessage() {

        String email = "user.can.feedBack@gmail.com";
        String password = "RedBul1234";
        String confirmPassword = "RedBul1234";
        ;

        String name = faker.name().fullName();
        String emailContact = "user.can.feedBackgmail.com";
        String text = faker.lorem().sentence(100);

        String emailLogin = "g.power@gmail.com";
        String passwordLogin = "GPower3333";

        String emailAccount = "user.can.feedBack@gmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.signUp();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.optionUser();
        registrationPage.registration(email, password, confirmPassword);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.clickContact();

        contactUsPage = new ContactUsPage(app.driver);
        contactUsPage.waitForLoading();
<<<<<<< HEAD
        contactUsPage.feedback(name, emailContact, text);
        checkFeedbackData(contactUsPage, name, emailContact, text);
        contactUsPage.sendMessageButtonClick();
        contactUsPage.waitForLoading();
        assertTrue("Invalid email format", contactUsPage.isErrorDisplayed());
=======
        contactUsPage.setFeedbackForm(name, emailContact, text);
        checkFeedbackData(contactUsPage, name, emailContact, text);
        contactUsPage.sendMessageButtonClick();
        contactUsPage.waitForLoading();
        assertTrue("Invalid email format", contactUsPage.istErrorDisplayed());
>>>>>>> origin/dev_Natalie
        contactUsPage.takeFeedbackFormPageScreenshot("User_cannot_feedback");

        header = new Header(app.driver);
        header.clickHome();
        header.tabDropdownMenu(SideBarInfo.LOGIN);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(emailLogin, passwordLogin);

        adminPanelPage = new AdminPanelPage(app.driver);
        adminPanelPage.waitForLoading();
        adminPanelPage.searchAccount(emailAccount);
        adminPanelPage.waitForLoading();
        adminPanelPage.clickDeleteAccount();
        adminPanelPage.searchAccount(emailAccount);

        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.LOGIN);
    }
}
