package e2e.pages.registration;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select/option[@value='user']")
    WebElement userOption;

    @FindBy(xpath = "//select/option[@value='admin']")
    WebElement adminOption;

    @FindBy(xpath = "//*[@name='email']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@class='input-password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@name='confirmPassword']")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//*[@class='registration-btn']")
    WebElement registrationButton;

    @Step("Wait for loading Login page")
    public void waitForLoading(){
        try {
            getWait().forVisibility(userOption);
            getWait().forVisibility(adminOption);
            getWait().forVisibility(emailInput);
            getWait().forVisibility(passwordInput);
            getWait().forVisibility(confirmPasswordInput);
            getWait().forVisibility(registrationButton);
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
    }
    public void optionUser(){
        userOption.click();
    }
    public void optionAdmin(){
        adminOption.click();
    }
    @Step("Registration as user: {email}, {password}, {confirmPassword}")
    public void registration(String email, String password, String confirmPassword) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
        registrationButton.click();
    }
}
