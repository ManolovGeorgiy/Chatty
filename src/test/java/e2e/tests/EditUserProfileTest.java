package e2e.tests;

import e2e.TestBase;
import e2e.enums.GenderInfo;
import e2e.enums.SideBarInfo;
import e2e.pages.EditUserForm;
import e2e.pages.HomeBlogPage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;

public class EditUserProfileTest extends TestBase {

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    EditUserForm editUserForm;

    @Test
    public void userCanEditProfile(){

        String email = "tatar@abv.bg";
        String password = "Manowar33246";

        String name = "Gera";
        String surname = "Manolov";
        String phone = "4915777777";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);
        homeBlogPage.waitForLoading();
        homeBlogPage.tabDropdownMenu(SideBarInfo.USERPROFILE);

        editUserForm = new EditUserForm(app.driver);
        editUserForm.clickEditButton();
        editUserForm.setProfileForm(name,surname,GenderInfo.MALE, phone);
        editUserForm.saveButtonClick();

    }
}
