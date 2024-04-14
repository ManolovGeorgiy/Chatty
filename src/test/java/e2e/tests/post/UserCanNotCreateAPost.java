package e2e.tests.post;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.CreateAPostForm;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.AssertJUnit.*;


public class UserCanNotCreateAPost extends TestBase {

    Faker faker = new Faker(new Locale("ENGLISH"));

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    CreateAPostForm createAPostForm;
    Header header;

    private void checkPostData(CreateAPostForm page, String title, String description, String content) {
        String actualTitle = page.getTitle();
        String actualDescription = page.getDescriptionText();
        String actualContent = page.getContent();
        Assert.assertEquals(actualTitle, title, actualTitle + " is not equal " + title);
        Assert.assertEquals(actualDescription, description, actualDescription + " is not equal " + description);
        Assert.assertEquals(actualContent, content, actualContent + " is not equal " + content);
    }

    @Epic(value = "User can not create a post")
    @Feature(value = "User not created post")
    @Description(value = "User can not create a post")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("15")
    @Test(description = "CHATTY-22")
    public void userCanNotCreateAPost() {
        String email = "tatar@abv.bg";
        String password = "Manowar33246";
        String title = faker.lorem().sentence(10);
        String description = faker.lorem().sentence(10);
        String content = faker.lorem().sentence(10);
        String imagePath = "C:\\Users\\PC\\Chatty\\reference\\path\\5204092180870848361_121.jpg";
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.createAPostClick();
        header.waitForLoading();

        createAPostForm = new CreateAPostForm(app.driver);
        createAPostForm.userCanNotCreateAPost(title, description, content);
        createAPostForm.imageLoading(imagePath);
        createAPostForm.waitForLoading();
        checkPostData(createAPostForm, title, description, content);
        createAPostForm.waitForLoading();
        assertTrue("Please fill the field", createAPostForm.errorText());
        createAPostForm.takePostPageScreenshot("User_can_not_create_a_post");
    }
}
