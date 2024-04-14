package e2e.pages.adminPanel;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPanelPage extends BasePage {
    public AdminPanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@type='text']")
    WebElement searchEmailInput;

    @FindBy(xpath = "//*[@class='email-btn']")
    WebElement emailButton;

    @FindBy(xpath = "//*[@class='svg-inline--fa fa-pen-to-square ']")
    WebElement editAccount;

    @FindBy(xpath = "//*[@class='svg-inline--fa fa-trash ']")
    WebElement deleteAccount;

    @Step("Wait for loading adminPanel panel")
    public void waitForLoading() {
        try {
            getWait().forVisibility(searchEmailInput);
            getWait().forVisibility(emailButton);
            getWait().forVisibility(editAccount);
            getWait().forVisibility(deleteAccount);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    @Step("search account")
    public void searchAccount(String emailAccount) {
        searchEmailInput.clear();
        searchEmailInput.sendKeys(emailAccount);
        emailButton.click();
    }

    @Step("click edit account button")
    public void clickEditAccount() {
        editAccount.click();
    }

    @Step("click deleterrr account button")
    public void clickDeleteAccount() {
        deleteAccount.click();
    }
}