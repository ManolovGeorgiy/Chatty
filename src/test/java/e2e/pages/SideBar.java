package e2e.pages;


import e2e.enums.SideBarInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class SideBar extends BasePage {
    public SideBar(WebDriver driver) {
        super(driver);
    }

    public void goToSideBarOption(SideBarInfo tab) {
        driver.findElement(By.xpath("//a[@href='/draft'" + tab.value + "']")).click();


    }
}
