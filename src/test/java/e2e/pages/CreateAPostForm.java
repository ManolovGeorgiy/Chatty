package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAPostForm extends BasePage{
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
    WebElement imageLoading;

    @FindBy(xpath = "//*[@id='publishDate']")
    WebElement publishData;

    @FindBy(xpath = "//*[@id='draftCheckbox']")
    WebElement draftTumblerSwitch;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitButton;

    @Step("Wait for loading Create a post")
    public void waitForLoading() {
        try {
            getWait().forVisibility(titleInput);
            getWait().forVisibility(descriptionInput);
            getWait().forVisibility(contentInput);
            getWait().forVisibility(imageLoading);
            getWait().forVisibility(publishData);
            getWait().forVisibility(draftTumblerSwitch);
            getWait().forVisibility(submitButton);

        } catch (StaleElementReferenceException e) {
        }
    }

    public void userCanCreateAPost(String title, String description, String content){
        titleInput.sendKeys(title);
        descriptionInput.sendKeys(description);
        contentInput.sendKeys(content);
        //imageLoading.sendKeys(imagePath);
        //publishData.sendKeys(date);

    }


    public void tumblerSwitch(){
        draftTumblerSwitch.click();
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
}
