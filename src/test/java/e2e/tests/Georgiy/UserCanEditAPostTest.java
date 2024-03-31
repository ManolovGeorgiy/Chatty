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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserCanEditAPostTest extends TestBase {

    Faker faker = new Faker();

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    Header header;
    EditPostPage editPostPage;
    EditAPostForm editAPostForm;

    public String selectRandomImagePath(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        List<String> imagePaths = new ArrayList<>();

        // Проверяем, что папка существует и содержит файлы
        if (files != null && files.length > 0) {
            // Фильтруем только файлы с расширением .jpg
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".jpg")) {
                    imagePaths.add(file.getAbsolutePath());
                }
            }
            // Если есть хотя бы одно изображение, выбираем случайный путь к нему
            if (!imagePaths.isEmpty()) {
                Random random = new Random();
                return imagePaths.get(random.nextInt(imagePaths.size()));
            } else {
                System.err.println("image" + folderPath + " не содержит изображений формата .jpg.");
                return null;
            }
        } else {
            System.err.println("image" + folderPath + " не существует или не содержит файлов.");
            return null;
        }
    }

    @Test
    public void userCanEditAPost() {
        // Генерация случайных данных для создания поста
        String email = "tatar@abv.bg";
        String password = "Manowar33246";
        String editTitle = "Привет";
        String editDescription = "Рассказ о месте";
        String editContent = "Это уникальное место";

        String image = "C:\\Users\\PC\\Chatty\\reference\\5204092180870848356_121.jpg";
        //String editTitle = faker.lorem().sentence(1);
        //String editDescription = faker.lorem().sentence(1);
        //String editContent = faker.lorem().sentence(70);
        //String folderPath = "C:\\Users\\PC\\Chatty\\reference";


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
        editAPostForm.waitForLoading();
        editAPostForm.editPost(editTitle,editDescription,editContent);
        editAPostForm.imageLoading(image);
        editAPostForm.waitForLoading();
        //String randomImagePath = selectRandomImagePath(folderPath);
        //if (randomImagePath != null) {
            //editAPostForm.imageLoading(randomImagePath);
            //editAPostForm.waitForLoading();
        //} else {
            //System.err.println("Не удалось выбрать изображение для публикации.");
        //}

        editAPostForm.clickEditSubmitButton();
        editAPostForm.waitForLoading();

        editPostPage = new EditPostPage(app.driver);
        editPostPage.waitForLoading();

        header = new Header(app.driver);
        header.clickLogo();
    }

}
