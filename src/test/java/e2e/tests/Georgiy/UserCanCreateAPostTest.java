package e2e.tests.Georgiy;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.CreateAPostForm;
import org.testng.annotations.Test;

public class UserCanCreateAPostTest extends TestBase {

    Faker faker = new Faker();

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    CreateAPostForm createAPostForm;
    Header header;



    @Test
    public void userCanCreateAPost() {
        String email = "tatar@abv.bg";
        String password = "Manowar33246";
        String title = faker.lorem().sentence(1);
        String description = faker.lorem().sentence(1);
        String content = faker.lorem().sentence(70);
        String imagePath = "C:\\Users\\PC\\Chatty\\reference\\5204092180870848057_121.jpg";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.createAPostClick();

        createAPostForm = new CreateAPostForm(app.driver);
        //createAPostForm.waitForLoading();
        createAPostForm.userCanCreateAPost(title, description, content);
        createAPostForm.imageLoading(imagePath);
        createAPostForm.waitForLoading();
        createAPostForm.clickSubmitButton();
    }
}
