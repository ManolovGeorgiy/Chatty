package e2e.pages.homeBlog;


import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeBlogPage extends BasePage {

    public HomeBlogPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@data-test='post-header__plus']")
    WebElement createAPostClick;

    @Step("Wait for loading HomeBlog page")
    public void waitForLoading() {
        try {

            getWait().forVisibility(createAPostClick);
        } catch (StaleElementReferenceException e) {
        }

    }

    public void createAPostButton() {
        createAPostClick.click();
    }
}

