package integration;

import com.github.javafaker.Faker;
import integration.user.UserApi;
import org.testng.annotations.Test;

public class UserApiTest extends UserApi {

    UserApi userApi;

    @Test
    public void userRegistration(){

        String email = "tatarrrrr@abv.bg";
        String password = "REdRED3333";
        String confirmPassword = "REdRED3333";
        String role = "user";
        String accessToken = "accessToken";
        String refreshToken = "refreshToken";


        userApi = new UserApi();
        userApi.newUserRegistration(email,password,confirmPassword,role,201);

        userApi.refreshToken(accessToken,refreshToken,200);
        userApi.login(email,password,200);
    }

}

