package integration.tests.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditUserProfileApiTest {
    //public class ProfileEditingTest {
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

            // Редактирование профиля
            WebElement editButton = driver.findElement(By.id("edit-button"));
            editButton.click();
            WebElement nameField = driver.findElement(By.id("name"));
            WebElement surnameField = driver.findElement(By.id("surname"));
            WebElement saveButton = driver.findElement(By.id("save-button"));
            nameField.clear();
            nameField.sendKeys("Петр");
            surnameField.clear();
            surnameField.sendKeys("Петров");
            saveButton.click();

            // Проверка успешного редактирования профиля
            WebElement successMessage = driver.findElement(By.id("success-message"));
            if(successMessage.getText().equals("Профиль успешно обновлен")) {
                System.out.println("Профиль успешно обновлен");
            } else {
                System.out.println("Ошибка при редактировании профиля");
            }

            driver.quit();
        }
    }

