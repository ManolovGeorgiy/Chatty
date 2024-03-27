package e2e.tests.Georgiy;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.contactUs.ContactUsPage;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.CreateAPostForm;
import org.testng.annotations.Test;

public class UserCanCreateAPostTest extends TestBase {

    Faker faker = new Faker();

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    CreateAPostForm createAPostForm;
    ContactUsPage contactUsPage;

    @Test
    public void userCanCreateAPost() {

        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        String title = faker.lorem().sentence(1);
        String description = faker.lorem().sentence(1);
        String content = faker.lorem().sentence(70);
        String image = "C:\\Users\\PC\\Pictures\\Screenshots\\Screenshot 2023-11-26 075141.png";
        //String date = "";
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();
        homeBlogPage.createAPostButton();

        createAPostForm = new CreateAPostForm(app.driver);
        createAPostForm.userCanCreateAPost(title, description, content);
        createAPostForm.waitForLoading();
        createAPostForm.imageLoading(image);
        createAPostForm.clickSubmitButton();
        //createAPostForm.waitForLoading();

        homeBlogPage = new HomeBlogPage(app.driver);





    }
}