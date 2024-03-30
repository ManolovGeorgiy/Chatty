package e2e.tests.Georgiy;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.Header;
import e2e.pages.contactUs.ContactUsPage;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.CreateAPostForm;
import e2e.pages.post.EditAPostForm;
import org.testng.annotations.Test;

public class UserCanEditAPostTest extends TestBase {

    Faker faker = new Faker();

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    Header header;
    EditAPostForm editAPostForm;


    @Test
    public void userCanEditAPost() {
        // Генерация случайных данных для создания поста
        String email = "tatar@abv.bg";
        String password = "Manowar33246";
        String title = faker.lorem().sentence(1);
        String description = faker.lorem().sentence(1);
        String content = faker.lorem().sentence(70);
        String image = "C:\\Users\\PC\\Pictures\\Screenshots\\Screenshot 2023-11-26 075141.png";

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

        editAPostForm = new EditAPostForm(app.driver);
        //editAPostForm.waitForLoading();

        editAPostForm.editPostButtonClick();
        editAPostForm.waitForLoading();
    }
}
