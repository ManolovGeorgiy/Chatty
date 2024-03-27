package e2e.tests;

import e2e.TestBase;
import e2e.enums.SideBarInfo;
import e2e.pages.*;
import org.testng.annotations.Test;

public class AdminPanelTest extends TestBase {

    LoginPage loginPage;
    RegistrationPage registrationPage;
    HomeBlogPage homeBlogPage;
    AdminPanelPage adminPanelPage;
    EditUserForm editUserForm;


    @Test
    public void deleteAccount(){

        String emailLogin = "g.power@gmail.com";
        String passwordLogin = "GPower3333";

        String emailAccount = "registrationUser1@gmail.com";

        String name = "Georgiy";
        String surname = "Manolov";
        String gender = "MALE";
        String phone = "+4915731078";

        String email = "registrationUser11@gmail.com";
        String password = "User3333";
        String confirmPassword = "User3333";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.signUp();
        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.optionUser();
        registrationPage.registration(email,password,confirmPassword);


        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();
        //homeBlogPage.tabDropdownMenu();
        //homeBlogPage.waitForLoading();



        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(emailLogin,passwordLogin);

        adminPanelPage = new AdminPanelPage(app.driver);
        adminPanelPage.waitForLoading();
        adminPanelPage.searchAccount(emailAccount);
        adminPanelPage.waitForLoading();

        //adminPanelPage.clickEditAccount();
        //editUserForm = new EditUserForm(app.driver);
        //editUserForm.clickEditButton();
        //editUserForm.setProfileForm(name,surname,gender,phone);
        //adminPanelPage.waitForLoading();

        adminPanelPage.clickDeleteAccount();


    }
}

