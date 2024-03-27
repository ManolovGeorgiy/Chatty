package e2e.pages.contactUs;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='name']")
    WebElement nameInput;

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id='content']")
    WebElement contentInput;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement sendMessageButton;

    @Step("Wait for loading Login page")
    public void waitForLoading() {
        try {
            getWait().forVisibility(nameInput);
            getWait().forVisibility(emailInput);
            getWait().forVisibility(contentInput);
            getWait().forVisibility(sendMessageButton);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }
    public void feedback(String name,String emailContact,String text, String newText){
        nameInput.sendKeys(name);
        emailInput.sendKeys(emailContact);
        contentInput.sendKeys(text);
        contentInput.clear();
        contentInput.sendKeys(newText);
        sendMessageButton.click();

    }
}
