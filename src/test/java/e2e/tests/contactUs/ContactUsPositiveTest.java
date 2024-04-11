package e2e.tests.contactUs;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.contactUs.ContactUsPage;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ContactUsPositiveTest extends TestBase {

    Faker faker = new Faker(new Locale("ENGLISH"));

    LoginPage loginPage;
    Header header;
    HomeBlogPage homeBlogPage;
    ContactUsPage contactUsPage;
    private void checkFeedbackData(ContactUsPage page, String userName, String userEmail, String userContent) {
        String actualUserName = page.getUserName();
        String actualUserEmail = page.getUserEmail();
        String actualUserContent = page.getUserContent();
        Assert.assertEquals(actualUserName, userName, actualUserName + " is not equal " + userName);
        Assert.assertEquals(actualUserEmail, userEmail, actualUserEmail + " is not equal " + userEmail);
        Assert.assertEquals(actualUserContent, userContent, actualUserContent + " is not equal " + userContent);
    }
    @Feature(value = "User can sent a message")
    @Description(value = "User can send setFeedbackForm")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "CHATTY-23")
    public void userCanSendMessage() {

        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        String userName = faker.name().fullName();
        String emailContact = faker.internet().emailAddress();
        String text = faker.lorem().sentence(100);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.clickContact();

        contactUsPage = new ContactUsPage(app.driver);
        contactUsPage.waitForLoading();
        contactUsPage.setFeedbackForm(userName, emailContact, text);
        contactUsPage.waitForLoading();
        checkFeedbackData(contactUsPage,userName,emailContact,text);
        contactUsPage.sendMessageButtonClick();
        assertTrue("Feedback submitted successfully!", contactUsPage.isMessageSent());
        contactUsPage.waitForLoading();

        header = new Header(app.driver);
        header.clickHome();
    }
}
