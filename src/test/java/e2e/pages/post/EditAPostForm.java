package e2e.pages.post;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAPostForm extends BasePage {

    private final By imageInputLocator = By.id("image");
    public EditAPostForm(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//*[@data-test='title-input']")
    WebElement titleInput;

    @FindBy(xpath = "//*[@data-test='description-input']")
    WebElement descriptionInput;

    @FindBy(xpath = "//*[@data-test='textarea']")
    WebElement contentInput;


    @FindBy(xpath = "//*[@class='close']")
    WebElement closButton;

    @FindBy(xpath = "//*[@id='draftCheckbox']")
    WebElement tumblerSwitch;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitEditButton;

    @FindBy(xpath = "//*[@class='close']")
    WebElement closeButton;

    @Step("Wait for loading edit a post")
    public void waitForLoading() {
        try {
            getWait().forVisibility(titleInput);
            getWait().forVisibility(descriptionInput);
            getWait().forVisibility(contentInput);
            getWait().forClickable(closButton);
            getWait().forVisibility(tumblerSwitch);
            getWait().forVisibility(submitEditButton);
            getWait().forVisibility(closButton);
        } catch (StaleElementReferenceException ignored) {
        }
    }
    public void editPost(String editTitle,String editDescription,String editContent){
        titleInput.clear();
        titleInput.sendKeys(editTitle);
        descriptionInput.clear();
        descriptionInput.sendKeys(editDescription);
        contentInput.clear();
        contentInput.sendKeys(editContent);
    }
    public void imageLoading(String imagePath) {
        try {
            WebElement fileInput = driver.findElement(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));
            fileInput.sendKeys(imagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void draftTumblerSwitch() {
        tumblerSwitch.click();
    }

    public void clickEditSubmitButton() {
        submitEditButton.click();
    }

}
