package e2e.pages.about;

import e2e.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends BasePage {
    public AboutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='about-box']")
    WebElement aboutBox;
    public String getAboutText() {
        return aboutBox.getText();
    }
}
