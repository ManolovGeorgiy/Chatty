package e2e.tests.Georgiy;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.*;
import e2e.pages.contactUs.ContactUsPage;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.CreateAPostForm;
import org.testng.annotations.Test;

public class FullTest extends TestBase {

    Faker faker = new Faker();

    LoginPage loginPage;
    Header header;
    HomeBlogPage homeBlogPage;
    CreateAPostForm createAPostForm;
    ContactUsPage contactUsPage;

    @Test
    public void userCanCreateAPostAndFeedback() {

        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        String name = "Georgiy";
        String emailContact = "tatar@abv.bg";
        String text = faker.lorem().sentence(100);
        String newText = faker.lorem().sentence(10);

        String title = faker.lorem().sentence(1);
        String description = faker.lorem().sentence(1);
        String content = faker.lorem().sentence(70);
        String image = "reference";
        //String date = "";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.createAPostClick();

        createAPostForm = new CreateAPostForm(app.driver);
        createAPostForm.userCanCreateAPost(title, description, content);
        createAPostForm.clickSubmitButton();

        header = new Header(app.driver);
        header.clickContact();

        contactUsPage = new ContactUsPage(app.driver);
        contactUsPage.waitForLoading();
        contactUsPage.feedback(name,emailContact,text,newText);
    }
}