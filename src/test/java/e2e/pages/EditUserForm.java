package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserForm extends BasePage{
    public EditUserForm(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@name='name']")
    WebElement nameInput;

    @FindBy(xpath = "//*[@name='surname']")
    WebElement surnameInput;

    @FindBy(xpath = "//select[@id='gender']/option[text()='MALE']")
    WebElement genderMale;

    @FindBy(xpath = "//select[@id='gender']/option[text()='FEMALE']")
    WebElement genderFemale;

    @FindBy(xpath = "//a[@id='birthDate']")
    WebElement birthDateForm;

    @FindBy(xpath = "//a[@name='phone']")
    WebElement phoneInput;

    @FindBy(xpath = "//a[@name='class='save__btn']")
    WebElement saveButton;

    @FindBy(xpath = "//a[@class='data-input pass__btn']")
    WebElement changePasswordButton;

    @Step("Wait for loading Edit profile page")
    public void waitForLoading() {
        try {

            getWait().forVisibility(nameInput);
            getWait().forVisibility(surnameInput);
            getWait().forVisibility(genderMale);
            getWait().forVisibility(genderFemale);
            getWait().forVisibility(birthDateForm);
            getWait().forVisibility(phoneInput);
            getWait().forVisibility(saveButton);
            getWait().forVisibility(changePasswordButton);

        } catch (StaleElementReferenceException e) {
        }
    }

    public void setProfileForm(String name, String surname, String gender, String date, String phone){
        nameInput.sendKeys(name);
        surnameInput.sendKeys(surname);
        genderMale.sendKeys(gender);
        birthDateForm.sendKeys(date);
        phoneInput.sendKeys(phone);
        saveButton.click();
    }
}
