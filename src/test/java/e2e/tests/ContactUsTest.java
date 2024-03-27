package e2e.tests;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.ContactUsPage;
import e2e.pages.HomeBlogPage;
import e2e.pages.LoginPage;
import io.restassured.http.Header;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase {

    Faker faker = new Faker();

    LoginPage loginPage;
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
        homeBlogPage.clickContactButton();

        contactUsPage = new ContactUsPage(app.driver);
        contactUsPage.waitForLoading();
        contactUsPage.feedback(name,emailContact,text,newText);
    }
}
