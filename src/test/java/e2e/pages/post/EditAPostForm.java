package e2e.pages.post;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAPostForm extends BasePage {
    public EditAPostForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='edit-button']")
    WebElement editButton;

    @FindBy(xpath = "//*[@class='close']")
    WebElement closButton;

    @FindBy(xpath = "//*[@data-test='title-input']")
    WebElement titleInput;

    @FindBy(xpath = "//*[@data-test='description-input']")
    WebElement descriptionInput;

    @FindBy(xpath = "//*[@data-test='textarea']")
    WebElement contentInput;

    @FindBy(xpath = "//*[@class='post_uploaded_image__7qSWV']")
    WebElement imageUpload;

    @FindBy(xpath = "//*[@id='draftCheckbox']")
    WebElement draftCheckBox;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitButton;

    @Step("Wait for loading edit a post")
    public void waitForLoading() {
        try {
            getWait().forVisibility(editButton);
            getWait().forVisibility(closButton);
            getWait().forVisibility(titleInput);
            getWait().forVisibility(descriptionInput);
            getWait().forVisibility(contentInput);
            getWait().forVisibility(imageUpload);
            getWait().forVisibility(draftCheckBox);
            getWait().forVisibility(submitButton);

        } catch (StaleElementReferenceException e) {
        }
    }
}
