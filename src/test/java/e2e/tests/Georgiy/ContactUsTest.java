package e2e.tests.Georgiy;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.contactUs.ContactUsPage;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase {

    Faker faker = new Faker();

    LoginPage loginPage;
    Header header;
    HomeBlogPage homeBlogPage;
    ContactUsPage contactUsPage;

    @Test
    public void userCanSendMessage(){

        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        String name = "Georgiy";
        String emailContact = "tatar@abv.bg";
        String text = faker.lorem().sentence(100);
        String newText = faker.lorem().sentence(10);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email,password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();
        header = new Header(app.driver);
        header.clickContactButton();


        contactUsPage = new ContactUsPage(app.driver);
        contactUsPage.waitForLoading();
        contactUsPage.feedback(name,emailContact,text,newText);
    }
}
