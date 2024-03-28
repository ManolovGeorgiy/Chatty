package e2e.pages.post;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//*[@id='draftCheckbox']")
    WebElement TumblerSwitch;

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
            getWait().forVisibility(TumblerSwitch);
            getWait().forVisibility(submitButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userCanCreateAPost(String title, String description, String content){
        titleInput.sendKeys(title);
        descriptionInput.sendKeys(description);
        contentInput.sendKeys(content);
        imageInput.click();
    }

    public void imageLoading(String imagePath){
        try {
            WebElement fileInput = driver.findElement(imageInputLocator);
            fileInput.sendKeys(imagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draftTumblerSwitch(){
        TumblerSwitch.click();
    }

    public void clickSubmitButton(){
        submitButton.click();
    }
}
