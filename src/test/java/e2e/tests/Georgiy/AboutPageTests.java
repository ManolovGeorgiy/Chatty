package e2e.tests.Georgiy;

import e2e.TestBase;
import e2e.pages.about.AboutPage;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import org.testng.annotations.Test;

public class AboutPageTests extends TestBase {

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    Header header;
    AboutPage aboutPage;
    @Test
    public void testAboutBoxText() {

        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        String expectedText = "about Chatty" + "Chatty is a social network platform designed to connect people and facilitate communication in a friendly and interactive environment. Our mission is to bring people together, encourage meaningful conversations, and create a positive online community." + "Join Chatty today and become a part of our growing community. Share your thoughts, connect with friends, and experience the joy of online socializing.";

        // Логин
        loginPage = new LoginPage(app.driver);
        loginPage.login(email,password);

        //Переход на страницу Домашнюю
        homeBlogPage = new HomeBlogPage(app.driver);

        // В шапке выбираем через нажатие "о нас"
        header = new Header(app.driver);
        header.waitForLoading();
        header.clickAbout();

        // Переход на страницу "о нас"
        aboutPage = new AboutPage(app.driver);

        // Получение текста из элемента "aboutbox"
        String actualText = aboutPage.getAboutText();

        // Проверка текста
        if (actualText.equals(expectedText)) {
            System.out.println("The text on the about page matches the expected text");
        } else {
            System.out.println("The text on the about page does not match the expected text");
        }
    }
}
