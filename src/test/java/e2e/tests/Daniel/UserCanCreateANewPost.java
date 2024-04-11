package e2e.tests.Daniel;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.CreateAPostForm;
import e2e.pages.post.EditPostPage;
import org.testng.Assert;
import org.testng.annotations.Test;

<<<<<<< HEAD

import java.util.Locale;

=======
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static org.testng.AssertJUnit.assertTrue;
>>>>>>> origin/dev_Pislaru

public class UserCanCreateANewPost extends TestBase {

    Faker faker = new Faker(new Locale("ENGLISH"));

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    CreateAPostForm createAPostForm;
    Header header;
    EditPostPage editPostPage;



    private void checkPostData(CreateAPostForm page, String title, String description, String content) {
        String actualTitle = page.getTitle();
        String actualDescription = page.getDescriptionText();
        String actualContent = page.getContent();
        Assert.assertEquals(actualTitle, title, actualTitle + " is not equal " + title);
        Assert.assertEquals(actualDescription, description, actualDescription + " is not equal " + description);
        Assert.assertEquals(actualContent, content, actualContent + " is not equal " + content);
    }

    @Test(description = "User can create a post")
    public void userCanCreateAPost() throws InterruptedException {
        String email = "Biba10@mail.ru";
        String password = "Biba1234";
        String title = "My first post";
        String description = "Pice";
        String content = faker.lorem().sentence(20);
        String imagePath = "src/test/java/resources/5204092180870848057_121.jpg";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.createAPostClick();
        header.waitForLoading();

        createAPostForm = new CreateAPostForm(app.driver);
        createAPostForm.userCanCreateAPost(title, description, content,imagePath);
        createAPostForm.waitForLoading();
        createAPostForm.imageLoading(imagePath);
        createAPostForm.waitForLoading();
        checkPostData(createAPostForm, title, description, content);
        createAPostForm.waitForLoading();
        createAPostForm.clickSubmitButton();
        Thread.sleep(3000);
        header = new Header(app.driver);
        header.myPostClick();
        header.waitForLoading();
        header.setMyPostTab();
        editPostPage = new EditPostPage(app.driver);
        editPostPage.waitForLoading();


        Assert.assertTrue(createAPostForm.isPostDisplayed(title), "Post with title: " + title + " is not displayed.");



    }
}
