package e2e.tests;

import e2e.TestBase;
import e2e.enums.SideBarInfo;
import e2e.pages.EditUserForm;
import e2e.pages.HomeBlogPage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;

public class EditProfileTest extends TestBase {

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;

    EditUserForm editUserForm;

    @Test
    public void userCanEditProfile(){

        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        String name = "Georgiy";
        String surname = "Manolov";
        String gender = "MALE";
        String phone = "#4915777777";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
        loginPage.waitForLoading();

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();
        homeBlogPage.tabDropdownMenu();

        homeBlogPage.openTab(SideBarInfo.USERPROFILE);





        editUserForm = new EditUserForm(app.driver);
        editUserForm.waitForLoading();
        editUserForm.setProfileForm(name,surname,gender,phone);

    }
}
