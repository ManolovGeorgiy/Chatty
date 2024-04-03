package e2e.pages.contactUs;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage extends BasePage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='name']")
    WebElement nameInput;

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id='content']")
    WebElement contentInput;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement sendMessageButton;

    @Step("Wait for loading Login page")
    public void waitForLoading() {
        try {
            getWait().forVisibility(nameInput);
            getWait().forVisibility(emailInput);
            getWait().forVisibility(contentInput);
            getWait().forVisibility(sendMessageButton);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }
    public void feedback(String name, String emailContact, String text, String newText) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(emailContact);
        contentInput.sendKeys(text);
        contentInput.clear();
        contentInput.sendKeys(newText);
        sendMessageButton.click();

        // Создание объекта Duration с указанием времени ожидания в секундах
        Duration timeout = Duration.ofSeconds(1);

        // Добавляем ожидание появления подтверждения успешной отправки сообщения
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success-message']")));
    }


    public boolean isMessageSent() {
        try {
            return driver.findElement(By.xpath("//div[@class='success-message']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false; // Возвращаем false, если элемент не найден
        }
    }
}
