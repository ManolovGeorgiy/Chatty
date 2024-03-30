package e2e.tests.Georgiy;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.enums.GenderInfo;
import e2e.enums.SideBarInfo;

import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.profile.EditUserForm;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditUserProfileTest extends TestBase {

    LoginPage loginPage;
    Header header;
    HomeBlogPage homeBlogPage;
    EditUserForm editUserForm;

    private void checkUserData(EditUserForm page, String name, String surname, String date, String phone) {
        String actualName = page.getName();
        String actualSurname = page.getSurname();
        String actualDate = page.getDate();
        String actualPhone = page.getPhone();
        Assert.assertEquals(actualName, name, actualName + " is not equal " + name);
        Assert.assertEquals(actualSurname, surname, actualSurname + " is not equal " + surname);
        Assert.assertEquals(actualDate, date, actualDate + " is not equal " + date);
        Assert.assertEquals(actualPhone, phone, actualPhone + " is not equal " + phone);
    }
    @Test
    public void userCanEditProfile() {

        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        String editName = "Georgiy";
        String editSurname = "Manolov";
        String editDate = "03.01.1985";
        String editPhone = "4915777777";
        String imageAvatar = "C:\\Users\\PC\\Chatty\\avatar\\5204092180870848055_121.jpg";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.USERPROFILE);

        editUserForm = new EditUserForm(app.driver);
        editUserForm.waitForLoading();

        editUserForm.clickEditUserForm();
        editUserForm.imageAvatarLoading(imageAvatar);
        editUserForm.setProfileForm(editName, editSurname, GenderInfo.MALE, editDate, editPhone);
        editUserForm.waitForLoading();
        editUserForm.saveButtonClick();
        editUserForm.waitForLoading();

        header = new Header(app.driver);
        header.clickHome();
    }
}