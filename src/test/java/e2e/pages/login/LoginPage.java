package e2e.pages.login;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//p[@class='link']/a[text()='Sign up']")
    WebElement signUpLink;

    @FindBy(xpath = "//*[@name='email']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@class='input-password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@class='registration-btn']")
    WebElement loginButton;

    @Step("Login page")
    public void waitForLoading(){
        try {
            getWait().forVisibility(signUpLink);
            getWait().forVisibility(emailInput);
            Assert.assertTrue(emailInput.isDisplayed());
            getWait().forVisibility(passwordInput);
            Assert.assertTrue(passwordInput.isDisplayed());
            getWait().forVisibility(loginButton);
        } catch (StaleElementReferenceException e) {
            driver.navigate().refresh();

        }
    }
    public void takeLoginPageScreenshot(String actualScreenshotName){
        try {
            waitForLoading();
            takeAndCompareScreenshot(actualScreenshotName, null);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }
    @Step("Login as user: {email}, {password}")
    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    @Step("Open Registration page")
    public void signUp(){
        try {
            signUpLink.click();
        } catch (StaleElementReferenceException e) {
            driver.navigate().refresh();
            signUp();
        }
    }
}
