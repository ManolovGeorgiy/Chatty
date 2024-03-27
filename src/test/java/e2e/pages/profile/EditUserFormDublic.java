package e2e.pages.profile;

import e2e.enums.GenderInfo;
import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserFormDublic extends BasePage {
    public EditUserFormDublic(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='post-header__plus']")
    WebElement editButton;

    @FindBy(xpath = "//*[@name='name']")
    WebElement nameInput;

    @FindBy(xpath = "//*[@name='surname']")
    WebElement surnameInput;

    @FindBy(xpath = "//select[@id='gender']")
    WebElement gender;

    @FindBy(xpath = "//*[@id='birthDate']")
    WebElement birthDateForm;

    @FindBy(xpath = "//*[@name='phone']")
    WebElement phoneInput;

    @FindBy(xpath = "//*[@class=data-input pass__btn']")
    WebElement changePasswordButton;

    @FindBy(xpath = "//*[@placeholder='Old password']")
    WebElement oldPasswordInput;

    @FindBy(xpath = "//*[@placeholder='New password']")
    WebElement newPasswordInput;

    @FindBy(xpath = "//*[@placeholder='Confirm new password']")
    WebElement confirmNewPasswordInput;

    @FindBy(xpath = "//*[@class='PasswordModal_pass_btn__eGL9h']")
    WebElement saveChangePasswordButton;

    @FindBy(xpath = "//*[@data-test='profileSaveButton']")
    WebElement saveButton;

    @Step("Wait for loading Edit profile page")
    public void waitForLoading() {
        try {
            getWait().forVisibility(editButton);
            getWait().forVisibility(nameInput);
            getWait().forVisibility(surnameInput);
            getWait().forVisibility(gender);
            getWait().forVisibility(birthDateForm);
            getWait().forVisibility(phoneInput);
            getWait().forVisibility(saveButton);
            getWait().forVisibility(changePasswordButton);
            getWait().forVisibility(oldPasswordInput);
            getWait().forVisibility(newPasswordInput);
            getWait().forVisibility(confirmNewPasswordInput);
            getWait().forVisibility(saveChangePasswordButton);
        } catch (StaleElementReferenceException e) {
        }
    }
    public void clickEditUserForm() {
        editButton.click();
    }
    public String getName() {
        return nameInput.getText();
    }
    public String getSurname() {
        return surnameInput.getText();
    }
    public String getDate() {
        return birthDateForm.getText();
    }
    public String getPhone() {
        return phoneInput.getText();
    }
    public void setProfileForm(String name, String surname, GenderInfo tab, String date, String phone) {
        nameInput.clear();
        nameInput.sendKeys(name);
        surnameInput.clear();
        surnameInput.sendKeys(surname);
        WebElement option = driver.findElement(By.xpath("//*[@value='" + tab.value + "']"));
        gender.click();
        getWait().forVisibility(option);
        option.click();
        birthDateForm.clear();
        birthDateForm.sendKeys(date);
        phoneInput.clear();
        phoneInput.sendKeys(phone);

    }
    public void changeUserPassword(String oldPassword,String newPassword, String confirmPassword){
        changePasswordButton.click();
        oldPasswordInput.sendKeys(oldPassword);
        newPasswordInput.sendKeys(newPassword);
        confirmNewPasswordInput.sendKeys(confirmPassword);
        saveChangePasswordButton.click();
    }
    public void saveButtonClick() {
        saveButton.click();
    }
}
