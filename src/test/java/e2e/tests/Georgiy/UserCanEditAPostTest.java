package e2e.tests.Georgiy;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.Header;
import e2e.pages.contactUs.ContactUsPage;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.CreateAPostForm;
import org.testng.annotations.Test;

public class UserCanEditAPostTest extends TestBase {

    Faker faker = new Faker();

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    Header header;


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

        homeBlogPage = new HomeBlogPage(app.driver);




        // Ожидание появления поста на главной странице
        homeBlogPage.waitForLoading();
        // Добавьте здесь проверку, что пост отображается на главной странице
    }
}
