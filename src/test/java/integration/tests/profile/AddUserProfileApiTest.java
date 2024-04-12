package integration.tests.profile;

import com.github.javafaker.Faker;
import e2e.enums.GenderInfo;
import e2e.enums.SideBarInfo;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.profile.AddUserDialog;
import integration.pages.user.UserApi;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.bouncycastle.oer.its.ieee1609dot2.EndEntityType.app;

public class AddUserProfileApiTest {
    UserApi userApi;

    LoginPage loginPage;
    Header header;
    HomeBlogPage homeBlogPage;
    AddUserDialog addUserDialog;

    Faker faker = new Faker();

    @Test
    public void testNewUserRegistration() {
        String email = "kolya@gmail.com";
        String password = "water998889";
        String confirmPassword = "water99889";
        String role = "user";

        userApi = new UserApi();
        userApi.registration(email, password, confirmPassword, role, 201);
        userApi.login(email, password, 200);


        String name = "mark";
        String surname = "marky";
        String date = "05-05-2005";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDate = LocalDate.parse(date, formatter);
        String phone = "+458889988";
        String imageAvatar = "C:\\Users\\PC\\Chatty\\avatar\\5204092180870848055_121.jpg";


    }
}