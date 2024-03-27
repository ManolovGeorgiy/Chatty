package e2e.tests;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.*;
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
        //String imagePath = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg";
        //String date = "";


        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();
        homeBlogPage.createAPostButton();

        createAPostForm = new CreateAPostForm(app.driver);
        createAPostForm.userCanCreateAPost(title, description, content);
        createAPostForm.clickSubmitButton();

        header = new Header(app.driver);
        header.clickContactButton();

        contactUsPage = new ContactUsPage(app.driver);
        contactUsPage.waitForLoading();
        contactUsPage.feedback(name,emailContact,text,newText);


    }
}