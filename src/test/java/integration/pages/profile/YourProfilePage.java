package integration.pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourProfilePage {
    private WebDriver driver;

    // Конструктор класса, принимающий WebDriver
    public YourProfilePage(WebDriver driver) {

        this.driver = driver;
    }

    // Метод для заполнения формы создания профиля
    public void fillProfileForm(String avatarUrl, String name, String surname, String birthDate, String phone, String gender, String backgroundUrl) {
        WebElement avatarUrlField = driver.findElement(By.id("avatar-url"));
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement surnameField = driver.findElement(By.id("surname"));
        WebElement birthDateField = driver.findElement(By.id("birth-date"));
        WebElement phoneField = driver.findElement(By.id("phone"));
        WebElement genderField = driver.findElement(By.id("gender"));
        WebElement backgroundUrlField = driver.findElement(By.id("background-url"));

        // Заполнение полей формы
        avatarUrlField.sendKeys(avatarUrl);
        nameField.sendKeys(name);
        surnameField.sendKeys(surname);
        birthDateField.sendKeys(birthDate);
        phoneField.sendKeys(phone);
        genderField.sendKeys(gender);
        backgroundUrlField.sendKeys(backgroundUrl);
    }

    // Метод для сохранения профиля
    public void saveProfile() {
        WebElement saveButton = driver.findElement(By.id("save-button"));
        saveButton.click();
    }

    // Метод для проверки успешного создания профиля
    public boolean isProfileCreated() {
        WebElement successMessage = driver.findElement(By.id("success-message"));
        return successMessage.getText().equals("Профиль успешно создан");
    }
}

