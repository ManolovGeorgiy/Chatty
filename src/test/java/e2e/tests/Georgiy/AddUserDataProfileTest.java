package e2e.tests.Georgiy;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.enums.GenderInfo;
import e2e.enums.SideBarInfo;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.profile.AddUserDialog;
import e2e.pages.profile.EditUserForm;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddUserDataProfileTest extends TestBase {

    Faker faker = new Faker();
    LoginPage loginPage;
    Header header;
    HomeBlogPage homeBlogPage;
    EditUserForm editUserForm;
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
    @Test
    public void userCanEditProfile() {

        String email = "tatar@abv.bg";
        String password = "Manowar333246";

        String name = "Georgiy";
        String surname = "Manolov";
        String date = "03.01.1985";
        String phone = "4915777777";
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
        addUserDialog.addProfileForm(name,surname,GenderInfo.MALE, date,phone);
        addUserDialog.waitForLoading();
        addUserDialog.saveButtonClick();
        addUserDialog.waitForLoading();
        //checkUserData(addUserDialog,name,surname,date,phone);


        header = new Header(app.driver);
        header.clickHome();
    }
}
