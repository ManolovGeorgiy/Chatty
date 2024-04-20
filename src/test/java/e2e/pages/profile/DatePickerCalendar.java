package e2e.pages.profile;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatePickerCalendar extends BasePage {

    public DatePickerCalendar(WebDriver driver) {super(driver);
    }

    @FindBy(xpath = "//*[@id='birthDate']")
    WebElement birthDateForm;

    @Step("Wait for loading Edit profile page")
    public void waitForLoading() {
        try {
            getWait().forVisibility(birthDateForm);
        } catch (StaleElementReferenceException e) {
        }
    }

    public void setDate(LocalDate date) {
        Wait wait = new WebDriverWait(driver,10);
        WebElement body = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("calendar-body")));
        WebElement currentDate = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("current-date")));

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
        WebElement dayCell = driver.findElement(By.xpath("//*[class='data-input'" + formattedDate + "')]"));
        currentDate.getText().equals(date.getMonth().name() + " " + date.getYear());
        dayCell.click();
        wait.until(ExpectedConditions.invisibilityOf(body));
    }
}
