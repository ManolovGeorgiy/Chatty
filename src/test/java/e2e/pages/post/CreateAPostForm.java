package e2e.pages.post;

import config.Config;
import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class CreateAPostForm extends BasePage {
    public CreateAPostForm(WebDriver driver) {
        super(driver);
    }

    private final Config config = new Config();

    @FindBy(xpath = "//*[@class='post-header']")
    public WebElement header;

    @FindBy(xpath = "//*[@name='title']")
    WebElement titleInput;

    @FindBy(xpath = "//*[@data-test='description-input']")
    WebElement descriptionInput;

    @FindBy(xpath = "//*[@name='content']")
    WebElement contentInput;

    @FindBy(xpath = "//*[@class='post_uploaded_image__7qSWV']")
    WebElement imageInput;

    @FindBy(xpath = "//*[@id='publishDate']")
    WebElement publishData;

    @FindBy(xpath = "//*[@for='draftCheckbox']")
    WebElement tumblerSwitchDraft;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitButton;
    @Step("Wait for loading Create a post")
    public void waitForLoading() {
        try {
            getWait().forVisibility(header);
            getWait().forVisibility(titleInput);
            getWait().forVisibility(descriptionInput);
            getWait().forVisibility(contentInput);
            getWait().forVisibility(imageInput);
            getWait().forVisibility(publishData);
            getWait().forClickable(tumblerSwitchDraft);
            getWait().forVisibility(submitButton);
            Assert.assertTrue(submitButton.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Step("Fill form {title},{description},{content},{path}")
    public void setPostForm(String title, String description, String content, String path) {
        titleInput.sendKeys(title);
        descriptionInput.sendKeys(description);
        contentInput.sendKeys(content);
    }

    public String getTitle() {
        return titleInput.getAttribute("value");
    }

    public String getDescriptionText() {
        return descriptionInput.getAttribute("value");
    }

    public String getContent() {
        return contentInput.getAttribute("value");
    }

    public void tumblerSwitchClick() {
        tumblerSwitchDraft.click();
    }

    @Step("Upload image: {relativeImagePath}")
    public void uploadImage(String relativeImagePath) {
        try {
            String selenoidImageUrl = getSelenoidFileUrl(relativeImagePath);
            WebElement fileInput = driver.findElement(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));
            fileInput.sendKeys(selenoidImageUrl);
            Thread.sleep(5000);
        } catch (Exception e) {
            Assert.fail("Failed to upload image: " + e.getMessage());
        }
    }

    public String getSelenoidFileUrl(String filename) {
        SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
        return String.format("%s/session/%s/aerokube/download/%s", config.getSelenoidUrl(), sessionId.toString(), filename);
    }
    
    @Step("Click Submit Button")
    public void clickSubmitButton() {
        submitButton.click();
    }
    @Step("check after sending")
    public boolean errorText() {
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='error']")));
        try {
            return driver.findElement(By.xpath("//*[@class='error']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    @Step("Screenshot {actualScreenshotName}")
    public void takePostPageScreenshot(String actualScreenshotName){
        try {
            waitForLoading();
            takeAndCompareScreenshot(actualScreenshotName, null);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }
    @Step("Fill form {title},{description},{content}")
    public void userCanNotCreateAPost(String title, String description, String content) {
        titleInput.sendKeys(title);
        descriptionInput.sendKeys(description);
        contentInput.sendKeys(content);
        submitButton.click();
    }

    public boolean isPostDisplayed(String postTitle) {
        try {
            WebElement postElement = driver.findElement(By.xpath("//*[@class='post-content__top' and .//h3[text()='" + postTitle + "']]"));;
            return postElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
//    public boolean isMessageSent() {
//        Duration timeout = Duration.ofSeconds(1);
//        // Добавляем ожидание появления подтверждения успешной отправки сообщения
//        WebDriverWait wait = new WebDriverWait(driver, timeout);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='post-content__top']")));
//        try {
//            return driver.findElement(By.xpath("//div[@class='post-content__top']")).isDisplayed();
//        } catch (NoSuchElementException e) {
//            return false; // Возвращаем false, если элемент не найден
//        }
//    }
}

