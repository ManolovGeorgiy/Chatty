package e2e.pages.post;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EditAPostForm extends BasePage {
    public EditAPostForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='title-input']")
    WebElement titleInput;

    @FindBy(xpath = "//*[@data-test='description-input']")
    WebElement descriptionInput;

    @FindBy(xpath = "//*[@data-test='textarea']")
    WebElement contentInput;


    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitEditButton;

    //@FindBy(xpath = "//*[@id='draftCheckbox']")
    //WebElement tumblerSwitch;

    @FindBy(xpath = "//*[@class='close']")
    WebElement closeButton;

    @Step("Wait for loading edit a post")
    public void waitForLoading() {
        try {
            getWait().forVisibility(titleInput);
            getWait().forVisibility(descriptionInput);
            getWait().forVisibility(contentInput);
            getWait().forVisibility(submitEditButton);
            //getWait().forVisibility(tumblerSwitch);
            getWait().forVisibility(closeButton);
        } catch (Exception e) {
            Assert.fail("Failed to load Create a post form: " + e.getMessage());
            e.printStackTrace();
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
        //tumblerSwitch.click();
    }
    public void clickEditSubmitButton() {
        submitEditButton.click();
    }
}
