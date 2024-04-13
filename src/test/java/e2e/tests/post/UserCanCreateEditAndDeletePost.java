package e2e.tests.post;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.enums.SideBarInfo;
import e2e.pages.Header;
import e2e.pages.adminPanel.AdminPanelPage;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.CreateAPostForm;
import java.util.Locale;

import e2e.pages.post.EditAPostForm;
import e2e.pages.post.EditPostPage;
import e2e.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanCreateEditAndDeletePost extends TestBase {

    Faker faker = new Faker(new Locale("ENGLISH"));

    LoginPage loginPage;
    RegistrationPage registrationPage;
    HomeBlogPage homeBlogPage;
    CreateAPostForm createAPostForm;
    Header header;
    EditPostPage editPostPage;
    EditAPostForm editAPostForm;
    AdminPanelPage adminPanelPage;
    private void checkPostData(CreateAPostForm page, String title, String description, String content) {
        String actualTitle = page.getTitle();
        String actualDescription = page.getDescriptionText();
        String actualContent = page.getContent();
        Assert.assertEquals(actualTitle, title, actualTitle + " is not equal " + title);
        Assert.assertEquals(actualDescription, description, actualDescription + " is not equal " + description);
        Assert.assertEquals(actualContent, content, actualContent + " is not equal " + content);
    }
    private void checkEditPostData(EditAPostForm page, String editTitle, String editDescription, String editContent) {
        String actualTitle = page.getEditTitle();
        String actualDescription = page.getEditDescriptionText();
        String actualContent = page.getEditContent();
        Assert.assertEquals(actualTitle, editTitle, actualTitle + " is not equal " + editTitle);
        Assert.assertEquals(actualDescription, editDescription, actualDescription + " is not equal " + editDescription);
        Assert.assertEquals(actualContent, editContent, actualContent + " is not equal " + editContent);
    }
    @Test(description = "User can create a post")
    public void userCanCreateAPost() throws InterruptedException {
        String email = "user.create.post@gmail.com";
        String password = "RedBul1234";
        String confirmPassword = "RedBul1234";

        String title = "My first post";
        String description = "My World";
        String content = faker.lorem().sentence(20);
        String imagePath = "src/test/java/resources/userCanCreateAPost_MyPost.jpg";

        String editTitle = "IT";
        String editDescription = "QA Engineer";
        String editContent = "HALLO WORLD";
        String editImagePath = "src/test/java/resources/userCanEditPost_MyPost.jpg";

        String emailLogin = "g.power@gmail.com";
        String passwordLogin = "GPower3333";

        String emailAccount = "user.create.post@gmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.signUp();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.optionUser();
        registrationPage.registration(email,password,confirmPassword);

        homeBlogPage = new HomeBlogPage(app.driver);
        //homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.createAPostClick();
        header.waitForLoading();

        createAPostForm = new CreateAPostForm(app.driver);
        createAPostForm.userCanCreateAPost(title, description, content,imagePath);
        createAPostForm.imageLoading(imagePath);
        createAPostForm.waitForLoading();

        checkPostData(createAPostForm, title, description, content);
        createAPostForm.clickSubmitButton();
        createAPostForm.waitForLoading();
        Thread.sleep(3000);
        header = new Header(app.driver);
        header.myPostClick();
        header.waitForLoading();
        header.setMyPostTab();
        editPostPage = new EditPostPage(app.driver);
        editPostPage.waitForLoading();

        Assert.assertTrue(createAPostForm.isPostDisplayed(title), "Post with title: " + title + " is not displayed.");

        editPostPage = new EditPostPage(app.driver);
        editPostPage.waitForLoading();
        editPostPage.editPostButtonClick();
        editPostPage.waitForLoading();

        editAPostForm = new EditAPostForm(app.driver);
        editAPostForm.waitForLoading();
        editAPostForm.imageLoading(editImagePath);
        editAPostForm.editPost(editTitle,editDescription,editContent);
        checkEditPostData(editAPostForm,editTitle,editDescription,editContent);
        editAPostForm.clickEditSubmitButton();

        Assert.assertTrue(editAPostForm.editIsPostDisplayed(title), "Post with title: " + title + " is not displayed.");

        editPostPage = new EditPostPage(app.driver);
        editPostPage.waitForLoading();
        editPostPage = new EditPostPage(app.driver);
        editPostPage.waitForLoading();
        editPostPage.deletePostButtonClick();


        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.LOGIN);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(emailLogin,passwordLogin);

        adminPanelPage = new AdminPanelPage(app.driver);
        adminPanelPage.waitForLoading();
        adminPanelPage.searchAccount(emailAccount);
        adminPanelPage.waitForLoading();
        adminPanelPage.clickDeleteAccount();
        adminPanelPage.searchAccount(emailAccount);

        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.LOGIN);
    }
}
