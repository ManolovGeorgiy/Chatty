package e2e.pages.post;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateAPostForm extends BasePage {
    public CreateAPostForm(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@class='post-header']")
    public WebElement header;

    @FindBy(xpath = "//*[@id='draftCheckbox']")
    WebElement tumblerSwitch;

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

    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitButton;

    @Step("Wait for loading Create a post")
    public void waitForLoading() {
        try {
            getWait().forVisibility(header);
            getWait().forVisibility(tumblerSwitch);
            getWait().forVisibility(titleInput);
            getWait().forVisibility(descriptionInput);
            getWait().forVisibility(contentInput);
            getWait().forVisibility(imageInput);
            getWait().forVisibility(publishData);
            getWait().forVisibility(submitButton);
            Assert.assertTrue(submitButton.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void tumblerSwitchClick() {
        tumblerSwitch.click();
    }

    @Step("Fill form {title},{description},{content}")
    public void userCanCreateAPost(String title, String description, String content) {
        titleInput.sendKeys(title);
        descriptionInput.sendKeys(description);
        contentInput.sendKeys(content);
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

    @Step("Click Submit Button")
    public void clickSubmitButton() {
        submitButton.click();
    }
}
