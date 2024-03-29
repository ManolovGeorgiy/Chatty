package e2e.tests.Georgiy;

import e2e.TestBase;
import e2e.enums.GenderInfo;
import e2e.enums.SideBarInfo;
import e2e.pages.Header;
import e2e.pages.adminPanel.AdminPanelPage;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.profile.AddUserDialog;
import e2e.pages.profile.EditPassword;
import e2e.pages.profile.EditUserForm;
import e2e.pages.registration.RegistrationPage;
import org.testng.annotations.Test;

public class UserFullTest extends TestBase {

    LoginPage loginPage;
    RegistrationPage registrationPage;
    HomeBlogPage homeBlogPage;
    Header header;
    AddUserDialog addUserDialog;
    EditPassword editPassword;


    @Test
    public void registrationAndAuthorisationUser() {

        String emailLogin = "tatara@abv.bg";
        String changePassword = "User3333";

        String email = "tatara@abv.bg";
        String password = "Tatara1234";
        String confirmPassword = "Tatara1234";

        String name = "Georgiy";
        String surname = "Manolov";
        String date = "03.01.1984";
        String phone = "4915777888";

        String oldPassword = "Tatara1234";
        String newPassword = "User3333";
        String confirmNewPassword = "User3333";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.signUp();
        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.optionUser();
        registrationPage.registration(email, password, confirmPassword);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.USERPROFILE);

        addUserDialog = new AddUserDialog(app.driver);
        addUserDialog.clickAddUserForm();
        addUserDialog.waitForLoading();
        addUserDialog.addProfileForm(name,surname,GenderInfo.MALE,date,phone);
        addUserDialog.saveButtonClick();

        editPassword = new EditPassword(app.driver);
        editPassword.changePassword(oldPassword,newPassword,confirmNewPassword);


        homeBlogPage =new HomeBlogPage(app.driver);


        header = new Header(app.driver);
        header.waitForLoading();
        header.tabDropdownMenu(SideBarInfo.LOGIN);
        header.waitForLoading();

        loginPage = new LoginPage(app.driver);
        loginPage.login(emailLogin,changePassword);

    }
}
