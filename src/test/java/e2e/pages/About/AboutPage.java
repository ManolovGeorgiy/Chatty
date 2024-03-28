package e2e.pages.About;

import e2e.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
;

public class AboutPage extends BasePage {
    public AboutPage(WebDriver driver) {
        super(driver);
    }
    public String getAboutText() {
        WebElement aboutBox = driver.findElement(By.xpath("//div[@class='about-box']"));
        return aboutBox.getText();
    }
}
