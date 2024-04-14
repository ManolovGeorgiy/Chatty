package integration.tests.profile;


import integration.pages.profile.YourProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AddUserProfileApiTest {
    public class ProfileCreationTest {
        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();
            driver.get("http://example.com");

            // Вход в систему
            // ...

            // Переход к странице профиля
            // ...

            YourProfilePage profilePage = new YourProfilePage(driver);

            // Заполнение формы профиля
            profilePage.fillProfileForm("https://example.com/avatar.jpg", "Иван", "Иванов", "1990-01-01", "+1234567890", "male", "https://example.com/background.jpg");
            profilePage.saveProfile();

            // Проверка успешного создания профиля
            Assert.assertTrue(profilePage.isProfileCreated());

            driver.quit();


            public class ProfileCreationTest {
                public static void main(String[] args) {
                    WebDriver driver = new ChromeDriver();
                    driver.get("http://example.com");

                    // Вход в систему
                    WebElement usernameField = driver.findElement(By.id("username"));
                    WebElement passwordField = driver.findElement(By.id("password"));
                    WebElement loginButton = driver.findElement(By.id("login-button"));
                    usernameField.sendKeys("your_username");
                    passwordField.sendKeys("your_password");
                    loginButton.click();

                    // Переход к странице профиля
                    WebElement profileLink = driver.findElement(By.id("profile-link"));
                    profileLink.click();

                    // Заполнение формы профиля
                    WebElement avatarUrlField = driver.findElement(By.id("avatar-url"));
                    WebElement nameField = driver.findElement(By.id("name"));
                    WebElement surnameField = driver.findElement(By.id("surname"));
                    WebElement birthDateField = driver.findElement(By.id("birth-date"));
                    WebElement phoneField = driver.findElement(By.id("phone"));
                    WebElement genderField = driver.findElement(By.id("gender"));
                    WebElement backgroundUrlField = driver.findElement(By.id("background-url"));
                    WebElement saveButton = driver.findElement(By.id("save-button"));
                    avatarUrlField.sendKeys("https://example.com/avatar.jpg");
                    nameField.sendKeys("Иван");
                    surnameField.sendKeys("Иванов");
                    birthDateField.sendKeys("1990-01-01");
                    phoneField.sendKeys("+1234567890");
                    genderField.sendKeys("male");
                    backgroundUrlField.sendKeys("https://example.com/background.jpg");
                    saveButton.click();

                    // Проверка успешного создания профиля
                    WebElement successMessage = driver.findElement(By.id("success-message"));
                    if (successMessage.getText().equals("Профиль успешно создан")) {
                        System.out.println("Профиль успешно создан");
                    } else {
                        System.out.println("Ошибка при создании профиля");
                    }

                    driver.quit();
                }
            }
        }
    }
}