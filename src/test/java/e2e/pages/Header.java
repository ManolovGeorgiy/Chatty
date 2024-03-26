package e2e.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);

    }
    @FindBy(xpath = "//*[@class='header-box']")
    WebElement headerBox;

    @FindBy(xpath = "//*[@class='header__nav open']")
    WebElement headerOpen;

    @FindBy(xpath = "//*[@class='header__logo']")
    WebElement logo;

    @FindBy(xpath = "//*[@'Home']")
    WebElement homeButton;

    @FindBy(xpath = "//*[@'about']")
    WebElement aboutButton;

    @FindBy(xpath = "//*[@class='header__nav open']//a[contains(@href,'contact')]")
    WebElement contactButton;

    @FindBy(xpath = "//*[@class='dropdown-menu']")
    WebElement dropdownMenu;


    public void waitForLoading(){
        try {
        getWait().forVisibility(headerBox);
        getWait().forVisibility(headerOpen);
        getWait().forVisibility(logo);
        getWait().forVisibility(homeButton);
        getWait().forVisibility(aboutButton);
        getWait().forVisibility(contactButton);
        getWait().forVisibility(dropdownMenu);
    } catch (
    StaleElementReferenceException e) {
    }
    }
    public void openContactPage(){
        contactButton.click();}
}

