package e2e.tests.Georgiy;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.contactUs.ContactUsPage;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.Locale;

public class ContactUsTest extends TestBase {

    Faker faker = new Faker(new Locale("en"));

    LoginPage loginPage;
    Header header;
    HomeBlogPage homeBlogPage;
    ContactUsPage contactUsPage;

    @Epic(value = "Contact Us")
    @Feature(value = "User can sent a message")
    @Description(value = "positive test :user can send feedback")
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("")
    @Test(description = "CHATTY-23")
    public void userCanSendMessage() {

        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        String name = faker.name().fullName();
        //String emailContact = "tatar@abv.bg";
        String emailContact = faker.internet().emailAddress();
        String text = faker.lorem().sentence(100);
        String newText = faker.lorem().sentence(10);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();
        header = new Header(app.driver);
        header.clickContact();

        contactUsPage = new ContactUsPage(app.driver);
        contactUsPage.waitForLoading();
        contactUsPage.feedback(name, emailContact, text, newText);
    }

    @Test(description = "")
    public void UserCanNotSendMessage(){
        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        String name = faker.name().fullName();
        String emailContact = "tatarabv.bg";
        String text = faker.lorem().sentence(100);
        String newText = faker.lorem().sentence(10);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();
        header = new Header(app.driver);
        header.clickContact();

        contactUsPage = new ContactUsPage(app.driver);
        contactUsPage.waitForLoading();
        contactUsPage.feedback(name, emailContact, text, newText);
    }
}
