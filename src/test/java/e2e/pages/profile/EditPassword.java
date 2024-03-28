package e2e.pages.profile;

import e2e.pages.BasePage;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPassword extends BasePage {
    public EditPassword(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='profileChangePasswordButton']")
    WebElement changePasswordButton;

    @FindBy(xpath = "//*[@placeholder='Old password']")
    WebElement oldPasswordInput;

    @FindBy(xpath = "//*[@placeholder='New password']")
    WebElement newPasswordInput;

    @FindBy(xpath = "//*[@placeholder='Confirm new password']")
    WebElement confirmNewPasswordInput;

    @FindBy(xpath = "//*[@class='PasswordModal_pass_btn__eGL9h']")
    WebElement saveChangeButton;

    public void waitForLoading() {
        try {
            getWait().forVisibility(changePasswordButton);
            getWait().forVisibility(oldPasswordInput);
            getWait().forVisibility(newPasswordInput);
            getWait().forVisibility(confirmNewPasswordInput);
            getWait().forVisibility(saveChangeButton);
        } catch (StaleElementReferenceException e) {
        }
    }
    public void changePassword(String oldPassword,String newPassword,String confirmNewPassword){
        changePasswordButton.click();
        oldPasswordInput.sendKeys(oldPassword);
        newPasswordInput.sendKeys(newPassword);
        confirmNewPasswordInput.sendKeys(confirmNewPassword);
        saveChangeButton.click();
    }
}
