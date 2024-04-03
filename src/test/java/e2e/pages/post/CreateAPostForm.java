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

    private By imageInputLocator = By.id("image");

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
            getWait().forVisibility(descriptionInput);
            getWait().forVisibility(contentInput);
            getWait().forVisibility(imageInput);
            getWait().forVisibility(publishData);
            getWait().forVisibility(tumblerSwitch);
            getWait().forVisibility(submitButton);
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

    @Step("upload image {imagePath}")
    public void imageLoading(String imagePath) {
        try {
            WebElement fileInput = driver.findElement(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));
            fileInput.sendKeys(imagePath);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    public void draftTumblerSwitch() {
        tumblerSwitch.click();
    }
    @Step("Click Button")
    public void clickSubmitButton() {
        submitButton.click();
    }
}
