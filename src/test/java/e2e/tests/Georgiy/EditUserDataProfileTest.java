package e2e.tests.Georgiy;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.enums.GenderInfo;
import e2e.enums.SideBarInfo;

import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.profile.EditPasswordForm;
import e2e.pages.profile.EditUserForm;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditUserDataProfileTest extends TestBase {

    Faker faker = new Faker();
    LoginPage loginPage;
    Header header;
    HomeBlogPage homeBlogPage;
    EditUserForm editUserForm;
    EditPasswordForm editPasswordForm;

    private void checkEditUserData(EditUserForm page, String name, String surname, String date, String phone) {
        String actualName = page.getName();
        String actualSurname = page.getSurname();
        String actualDate = page.getDate();
        String actualPhone = page.getPhone();
        Assert.assertEquals(actualName, name, actualName + " is not equal " + name);
        Assert.assertEquals(actualSurname, surname, actualSurname + " is not equal " + surname);
        Assert.assertEquals(actualDate, date, actualDate + " is not equal " + date);
        Assert.assertEquals(actualPhone, phone, actualPhone + " is not equal " + phone);
    }
    @Test(description = "CHATTY-30")
    public void userCanEditProfile() {

        String email = "tatar@abv.bg";
        String password = "Manowar333246";

        String editName = "Georgiy";
        String editSurname = "Manolov";
        String editDate = "03.01.1985";
        String editPhone = "4915731078";
        String editImageAvatar = "C:\\Users\\PC\\Chatty\\avatar\\5206343980684532308_121.jpg";

        String oldPassword = "Manowar333246";
        String newPassword = "Manowar33246";
        String confirmNewPassword = "Manowar33246";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.USERPROFILE);

        editUserForm = new EditUserForm(app.driver);
        editUserForm.waitForLoading();
        editUserForm.imageAvatarLoading(editImageAvatar);
        editUserForm.waitForLoading();
        editUserForm.clickEditUserForm();
        editUserForm.waitForLoading();



        editUserForm.setProfileForm(editName, editSurname, GenderInfo.MALE, editDate, editPhone);
        editUserForm.waitForLoading();
        editUserForm.saveButtonClick();
        editUserForm.waitForLoading();
        //checkEditUserData(editUserForm,editName,editSurname,editDate,editPhone);

        editPasswordForm = new EditPasswordForm(app.driver);
        editPasswordForm.changePassword(oldPassword,newPassword,confirmNewPassword);
        editPasswordForm.saveChangePasswordButton();

        header = new Header(app.driver);
        header.clickHome();
        header.tabDropdownMenu(SideBarInfo.LOGIN);

        loginPage = new LoginPage(app.driver);
        loginPage.login(email,confirmNewPassword);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();



    }
}