package e2e.tests;

import e2e.TestBase;
import e2e.enums.GenderInfo;
import e2e.enums.SideBarInfo;
import e2e.pages.*;
import e2e.pages.adminPanel.AdminPanelPage;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.profile.EditUserForm;
import e2e.pages.registration.RegistrationPage;
import org.testng.annotations.Test;

public class AdminPanelTest extends TestBase {

    LoginPage loginPage;
    RegistrationPage registrationPage;
    HomeBlogPage homeBlogPage;
    Header header;
    AdminPanelPage adminPanelPage;
    EditUserForm editUserForm;
    @Test
    public void deleteAccount(){

        String emailLogin = "g.power@gmail.com";
        String passwordLogin = "GPower3333";

        String emailAccount = "registrationUser11@gmail.com";

        String email = "registrationUser11@gmail.com";
        String password = "User3333";
        String confirmPassword = "User3333";

        String name = "Daniel";
        String surname = "Daniel";
        String date = "03.01.1984";
        String phone = "4915777888";

        String oldPassword = "User3333";
        String newPassword = "User3333";
        String confirmNewPassword = "User3333";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.signUp();
        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.optionUser();
        registrationPage.registration(email,password,confirmPassword);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();
        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.LOGIN);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(emailLogin,passwordLogin);

        adminPanelPage = new AdminPanelPage(app.driver);
        adminPanelPage.waitForLoading();
        adminPanelPage.searchAccount(emailAccount);
        adminPanelPage.waitForLoading();
        adminPanelPage.clickEditAccount();

        editUserForm = new EditUserForm(app.driver);
        editUserForm.waitForLoading();

        editUserForm.clickEditUserForm();
        editUserForm.setProfileForm(name, surname, GenderInfo.MALE, date, phone);
        editUserForm.waitForLoading();
        editUserForm.saveButtonClick();
        editUserForm.waitForLoading();
        //editUserForm.changeUserPassword(oldPassword,newPassword,confirmNewPassword);


        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.USERS);

        adminPanelPage = new AdminPanelPage(app.driver);
        adminPanelPage.waitForLoading();
        adminPanelPage.searchAccount(emailAccount);
        adminPanelPage.waitForLoading();
        adminPanelPage.clickDeleteAccount();

        header = new Header(app.driver);
        header.clickHomeButton();


        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();

        header = new Header(app.driver);
        header.tabDropdownMenu(SideBarInfo.LOGIN);
        loginPage = new LoginPage(app.driver);
    }
}

