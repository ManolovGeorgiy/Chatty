package e2e.tests.Georgiy;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.EditAPostForm;
import e2e.pages.post.EditPostPage;
import org.testng.annotations.Test;

public class UserCanEditAPostTest extends TestBase {

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    Header header;
    EditPostPage editPostPage;
    EditAPostForm editAPostForm;

    @Test
    public void userCanEditAPost() {

        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        String editTitle = "IT";
        String editDescription = "QA Engineer";
        String editContent = "HALLO WORLD";
        String imagePath = "C:\\Users\\PC\\Chatty\\reference\\Best-AI-tools-for-Image-Processing.jpg";


        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);

        header = new Header(app.driver);
        header.waitForLoading();
        header.myPostClick();
        header.waitForLoading();
        header.setMyPostTab();

        editPostPage = new EditPostPage(app.driver);
        editPostPage.waitForLoading();
        editPostPage.editPostButtonClick();
        editPostPage.waitForLoading();

        editAPostForm = new EditAPostForm(app.driver);
        editAPostForm.waitForLoading();
        editAPostForm.imageLoading(imagePath);
        editAPostForm.editPost(editTitle,editDescription,editContent);
        editAPostForm.clickEditSubmitButton();

        editPostPage = new EditPostPage(app.driver);
        editPostPage.waitForLoading();

    }
}
