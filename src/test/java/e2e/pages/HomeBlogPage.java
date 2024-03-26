package e2e.pages;

import e2e.enums.SideBarInfo;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeBlogPage extends BasePage {

    public HomeBlogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='header']")
    WebElement headerElement;

    @FindBy(xpath = "//*[@class='header__nav header__menu']")
    WebElement headerMenu;

    @FindBy(xpath = "//*[@class='header__nav-list']")
    WebElement headerList;

    @FindBy(xpath = "//a[@href='/homeblog' and text()='Home']")
    WebElement homeButton;

    @FindBy(xpath = "//a[@href='/contact' and text()='Contact']")
    WebElement contactButton;

    @FindBy(xpath = "//*[@class='header__user header__menu']")
    WebElement dropdownMenu;

    @FindBy(xpath = "//*[@data-test='post-header__plus']")
    WebElement createAPostClick;

    @Step("Wait for loading HomeBlog page")
    public void waitForLoading() {
        try {
            getWait().forVisibility(headerElement);
            getWait().forVisibility(headerMenu);
            getWait().forVisibility(headerList);
            getWait().forVisibility(homeButton);
            getWait().forVisibility(contactButton);
            getWait().forClickable(dropdownMenu);
            getWait().forVisibility(createAPostClick);
        } catch (StaleElementReferenceException e) {
        }

    }
    public void clickHomeButton() {
        homeButton.click();
    }
    public void clickContactButton() {
        contactButton.click();
    }
    public void tabDropdownMenu() {
        dropdownMenu.click();
    }
    public void openPage(SideBarInfo tab) {
        WebElement option = driver.findElement(By.xpath("//a[@href='" + tab.value + "']"));
        dropdownMenu.click();
        getWait().forVisibility(option);
        option.click();
    }
    public void createAPostButton() {
        createAPostClick.click();
    }
}

