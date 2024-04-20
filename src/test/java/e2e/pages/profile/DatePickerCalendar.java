package e2e.pages.profile;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wait.Wait;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatePickerCalendar extends BasePage {

    public DatePickerCalendar(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "birthDate")
    WebElement birthDateInput;

    @Step("Wait for loading Edit profile page")
    public void waitForLoading() {
        try {
            getWait().forVisibility(birthDateInput);
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    public void setDate(LocalDate date) {
        Wait wait = new Wait(driver);
        WebElement body = (WebElement) wait.setWait(ExpectedConditions.visibilityOfElementLocated(By.className("calendar-body")));
        WebElement currentDate = (WebElement) wait.setWait(ExpectedConditions.visibilityOfElementLocated(By.className("current-date")));

        String[] currentMothAndYear = currentDate.getText().split(" ");
        int currentMonth = Month.valueOf(currentMothAndYear[0].toUpperCase()).getValue();
        int currentYear = Integer.parseInt(currentMothAndYear[1]);
        int monthDiff = (date.getYear() - currentYear) * 12 + (date.getMonthValue() - currentMonth);
        WebElement rightArrow = driver.findElement(By.className("arrow-right"));
        WebElement leftArrow = driver.findElement(By.className("arrow-left"));
        for (int i = 0; i < Math.abs(monthDiff); i++) {
            if (monthDiff > 0) {
                rightArrow.click();
            } else {
                leftArrow.click();
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd", Locale.ENGLISH);
        String formattedDate = date.format(formatter);
        WebElement dayCell = driver.findElement(By.xpath("//*[contains(@class, 'data-input') and contains(text(), '" + formattedDate + "')]"));
        currentDate.getText().equals(date.getMonth().name() + " " + date.getYear());
        dayCell.click();

    }

    @Step("Set birth date")
    public void setBirthDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(formatter);
        birthDateInput.sendKeys(formattedDate);
    }
}
