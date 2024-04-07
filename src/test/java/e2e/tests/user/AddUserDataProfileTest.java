package e2e.tests.user;


import e2e.TestBase;
import e2e.enums.GenderInfo;
import e2e.enums.SideBarInfo;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.profile.AddUserDialog;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddUserDataProfileTest extends TestBase {


    LoginPage loginPage;
    Header header;
    HomeBlogPage homeBlogPage;
    AddUserDialog addUserDialog;

    private void checkUserData(AddUserDialog page, String name, String surname, String date, String phone) {
        String actualName = page.getName();
        String actualSurname = page.getSurname();
        String actualDate = page.getDate();
        String actualPhone = page.getPhone();
        Assert.assertEquals(actualName, name, actualName + " is not equal " + name);
        Assert.assertEquals(actualSurname, surname, actualSurname + " is not equal " + surname);
        Assert.assertEquals(actualDate, date, actualDate + " is not equal " + date);
        Assert.assertEquals(actualPhone, phone, actualPhone + " is not equal " + phone);
    }
    @Epic(value = "User can add data to the profile")
    @Feature(value = "User added data to the profile")
    @Description(value = "User can add data")
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("")
    @Test(description = "CHATTY-29")
    public void userCanAddDataProfile() {

        String email = "tatar@abv.bg";
        String password = "Manowar333246";

        String name = "Georg";
        String surname = "Man";
        String date = "08-01-1984";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDate = LocalDate.parse(date, formatter);
        String phone = "+49157777774";
        String imageAvatar = "C:\\Users\\PC\\Chatty\\avatar\\5204092180870848055_121.jpg";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.USERPROFILE);

        addUserDialog = new AddUserDialog(app.driver);
        addUserDialog.waitForLoading();
        addUserDialog.imageAvatarLoading(imageAvatar);
        addUserDialog.clickAddUserForm();
        addUserDialog.waitForLoading();
        addUserDialog.addProfileForm(name,surname,GenderInfo.MALE,date,phone);
        addUserDialog.waitForLoading();
        addUserDialog.saveButtonClick();
        addUserDialog.waitForLoading();
        checkUserData(addUserDialog,name,surname,birthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),phone);

        header = new Header(app.driver);
        header.clickHome();
    }
}
