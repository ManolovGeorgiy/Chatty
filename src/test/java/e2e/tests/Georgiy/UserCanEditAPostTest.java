package e2e.tests.Georgiy;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.Header;
import e2e.pages.contactUs.ContactUsPage;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.CreateAPostForm;
import e2e.pages.post.EditAPostForm;
import e2e.pages.post.EditPostPage;
import org.testng.annotations.Test;

public class UserCanEditAPostTest extends TestBase {

    Faker faker = new Faker();

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    Header header;
    EditPostPage editPostPage;
    EditAPostForm editAPostForm;


    @Test
    public void userCanEditAPost() {
        // Генерация случайных данных для создания поста
        String email = "tatar@abv.bg";
        String password = "Manowar33246";
        String editTitle = faker.lorem().sentence(1);
        String editDescription = faker.lorem().sentence(1);
        String editContent = faker.lorem().sentence(70);
        String image = "C:\\Users\\PC\\Chatty\\reference\\5204092180870848344_121.jpg";

        // Вход на сайт
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);


        // Переход на страницу создания поста
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
        editAPostForm.editPost(editTitle,editDescription,editContent);
        editAPostForm.editImageLoading(image);
        editAPostForm.clickSubmitButton();
        editAPostForm.waitForLoading();

        editPostPage = new EditPostPage(app.driver);
        editPostPage.waitForLoading();

        header = new Header(app.driver);
        header.clickHome();




    }
}
