package e2e.pages.post;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateAPostForm extends BasePage {
    public CreateAPostForm(WebDriver driver) {
        super(driver);
    }

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

    @FindBy(xpath = "//*[@class='post-header__checkbox']")
    WebElement tumblerSwitch;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitButton;

    @Step("Wait for loading Create a post")
    public void waitForLoading() {
        try {
            getWait().forVisibility(titleInput);
            Assert.assertTrue(titleInput.isDisplayed());
            getWait().forVisibility(descriptionInput);
            Assert.assertTrue(descriptionInput.isDisplayed());
            getWait().forVisibility(contentInput);
            Assert.assertTrue(contentInput.isDisplayed());
            getWait().forVisibility(imageInput);
            Assert.assertTrue(imageInput.isDisplayed());
            getWait().forVisibility(publishData);
            Assert.assertTrue(publishData.isDisplayed());
            getWait().forVisibility(tumblerSwitch);
            Assert.assertTrue(tumblerSwitch.isDisplayed());
            getWait().forVisibility(submitButton);
            Assert.assertTrue(submitButton.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Fill form {title},{description},{content}")
    public void userCanCreateAPost(String title, String description, String content) {
        titleInput.sendKeys(title);
        Assert.assertTrue(titleInput.isDisplayed());
        descriptionInput.sendKeys(description);
        Assert.assertTrue(descriptionInput.isDisplayed());
        contentInput.sendKeys(content);
        Assert.assertTrue(contentInput.isDisplayed());
        imageInput.click();
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


    @Step("Upload image: {imagePath}")
    public void imageLoading(String imagePath) {
        try {
            WebElement fileInput = driver.findElement(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));
            fileInput.sendKeys(imagePath);
        } catch (Exception e) {
            Assert.fail("Failed to upload image: " + e.getMessage());
        }
    }

    public void draftTumblerSwitch() {
        tumblerSwitch.click();
    }
    @Step("Click Submit Button")
    public void clickSubmitButton() {
        submitButton.click();
    }
}
