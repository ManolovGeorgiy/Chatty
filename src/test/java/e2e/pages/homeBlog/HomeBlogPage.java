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

    @FindBy(xpath = "//*[@class='sidebar__section']")
    WebElement sectionSidebar;

    //@FindBy(xpath = "//*[@class='menu-item']//a[@href='/homeblog']")
    //WebElement homeBlogButton;

    //@FindBy(xpath = "//a[@class='menu-item']//a[@href='/draft']")
    //WebElement draftButton;

    @Step("Wait for loading HomeBlog page")
    public void waitForLoading() {
        try {
            getWait().forVisibility(sectionSidebar);
            //getWait().forVisibility(homeBlogButton);
            //getWait().forVisibility(draftButton);
        } catch (StaleElementReferenceException e) {
        }
    }
    public void clickHomeBlogButton(){
        sectionSidebar.sendKeys();
        //homeBlogButton.click();
    }

    public void clickDraftButton(){
        sectionSidebar.sendKeys();
        //draftButton.click();
    }

}

