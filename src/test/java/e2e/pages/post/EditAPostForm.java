package e2e.pages.post;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAPostForm extends BasePage {
    public EditAPostForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='edit-button']")
    WebElement editPostButton;

    @FindBy(xpath = "//*[@data-test='title-input']")
    WebElement titleInput;

    @FindBy(xpath = "//*[@data-test='description-input']")
    WebElement descriptionInput;

    @FindBy(xpath = "//*[@data-test='textarea']")
    WebElement contentInput;

    @FindBy(xpath = "//*[@class='post_uploaded_image__7qSWV']")
    WebElement imageUpload;

    @FindBy(xpath = "//*[@class='close']")
    WebElement closButton;

    //@FindBy(xpath = "//*[@id='draftCheckbox']")
    //WebElement tumblerSwitch;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitButton;

    @Step("Wait for loading edit a post")
    public void waitForLoading() {
        try {
            getWait().forClickable(editPostButton);

            getWait().forVisibility(titleInput);
            getWait().forVisibility(descriptionInput);
            getWait().forVisibility(contentInput);
            getWait().forVisibility(imageUpload);
            getWait().forClickable(closButton);
            //getWait().forVisibility(tumblerSwitch);
            getWait().forVisibility(submitButton);

        } catch (StaleElementReferenceException e) {
        }
    }

    public void editPostButtonClick(){
        WebElement editButton = driver.findElement((By.xpath("//*[@data-test='edit-button']")));
        editButton.click();

    }
    public void editPost(String editTitle,String editDescription,String editContent){
        titleInput.clear();
        titleInput.sendKeys(editTitle);
        descriptionInput.clear();
        descriptionInput.sendKeys(editDescription);
        contentInput.clear();
        contentInput.sendKeys();
    }
    public void editImageLoading(String imagePath) {
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

    public void clickSubmitButton() {
        submitButton.click();
    }

}
