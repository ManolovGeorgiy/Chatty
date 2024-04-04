package e2e.tests.Georgiy;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.Header;
import e2e.pages.adminPanel.AdminPanelPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.CreateAPostForm;
import e2e.pages.profile.AddUserDialog;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCanCreateAPostTest extends TestBase {

    Faker faker = new Faker();

    LoginPage loginPage;
    AdminPanelPage adminPanelPage;
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
    @Test
    public void adminCanCreateAPost() {
        String email = "g.power@gmail.com";
        String password = "GPower3333";
        String title = faker.lorem().sentence(1);
        String description = faker.lorem().sentence(1);
        String content = faker.lorem().sentence(50);
        String imagePath = "C:\\Users\\PC\\Chatty\\reference\\path\\Best-AI-tools-for-Image-Processing.jpg";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        adminPanelPage = new AdminPanelPage(app.driver);
        adminPanelPage.waitForLoading();

        header = new Header(app.driver);
        header.clickHome();
        header.createAPostClick();

        createAPostForm = new CreateAPostForm(app.driver);
        createAPostForm.userCanCreateAPost(title, description, content);
        createAPostForm.waitForLoading();
        createAPostForm.imageLoading(imagePath);
        createAPostForm.waitForLoading();
        checkPostData(createAPostForm, title,description,content);
        createAPostForm.clickSubmitButton();
        createAPostForm.waitForLoading();

    }
}
