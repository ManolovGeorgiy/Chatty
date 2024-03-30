package e2e.pages.post;

import e2e.TestBase;
import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPostPage extends BasePage {
    public EditPostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='edit-button']")
    WebElement editPostButton;

    @FindBy(xpath = "//*[@data-test='delete-button']")
    WebElement deletePostButton;

    @Step("Wait for loading edit a post")
    public void waitForLoading() {
        try {
            getWait().forClickable(editPostButton);
            getWait().forVisibility(deletePostButton);
        } catch (StaleElementReferenceException e) {
        }
    }

    public void editPostButtonClick(){
        editPostButton.click();

        // editButton = driver.findElement((By.xpath("//*[@data-test='edit-button']")));
        //editButton.click();
    }
    public void deletePostButtonClick() {
        deletePostButton.click();
    }
}
